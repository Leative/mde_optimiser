package uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.output

import com.google.common.io.Files
import java.io.File
import java.io.PrintWriter
import java.nio.file.Path
import java.nio.file.Paths
import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Date
import java.util.HashMap
import java.util.LinkedList
import java.util.List
import java.util.Map
import java.util.TimeZone
import org.deeplearning4j.arbiter.optimize.api.OptimizationResult
import uk.ac.kcl.inf.mdeoptimiser.languages.mopt.Optimisation
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.moea.SearchResult
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.output.descriptors.AccumulatorSerialiser
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.output.descriptors.BatchReportsDescriptor
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.output.descriptors.ExperimentCSVSerializer
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.output.descriptors.GeneratedMutationOperatorsDescriptor
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.output.descriptors.MOEAObjectivesOutputDescriptor
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.output.descriptors.ParetoChartOutputDescriptor
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.output.descriptors.ResultsDescriptor
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.output.descriptors.SystemInformationDescriptor
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.output.descriptors.TextDescriptor
import uk.ac.kcl.mdeoptimiser.libraries.core.optimisation.hyperparameter.arbiter.MDEOHyperparametersConfiguration
import uk.ac.kcl.mdeoptimiser.libraries.core.optimisation.hyperparameter.arbiter.saver.MDEOParameterSearchResult
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.output.descriptors.MoptSpecSerialiser

class MDEOResultsOutput {
	
	Date experimentStartTime;
	List<MDEOBatch> batches;
	Path projectRoot;
	Path moptFile;
	Optimisation moptConfiguration;
	List<ResultsDescriptor> resultsDescriptors;
	boolean classicRuleMatchingEnabled;
		
	new(Date startTime, Path projectRoot, Path moptFile, Optimisation moptConfiguration){
		experimentStartTime = startTime
		//Store output of a batch experiment id, solutions set
		batches = new LinkedList<MDEOBatch>();
		this.projectRoot = projectRoot;
		this.moptConfiguration = moptConfiguration;
		this.moptFile = moptFile;
		this.resultsDescriptors = loadDescriptors();
		this.classicRuleMatchingEnabled = classicRuleMatchingEnabled;
	}
	
	def void logBatch(MDEOBatch batch){
		batches.add(batch);
	}

	def void saveOutcome(){
		this.saveOutcome(null)
	}

	def void saveOutcome(Integer customBatch){
		
		//When running custom batches no date is needed
		var outcomePath = Paths.get(projectRoot.toString, String.format("mdeo-results/experiment-%s/", 
			moptFile.last
		));
		
		if(customBatch === null) {
			val experimentDate = new SimpleDateFormat("yyMMdd-HHmmss").format(experimentStartTime);
			outcomePath = Paths.get(projectRoot.toString, String.format("mdeo-results/experiment-%s-%s/", 
				moptFile.last, experimentDate
			));
		}
		
		//Used to generate the experiments summary	
		val batchesOutput = new StringBuilder();
		
		val outcomePathVal = outcomePath
		
		batches.forEach[ batch | 
		
			batchesOutput.append("============================================")
			batchesOutput.append(System.getProperty("line.separator"));
			
			val batchOutputPath = Paths.get(outcomePathVal.toString, String.format("batch-%s/", batch.id))
			
			this.resultsDescriptors.forEach[ descriptor |
				descriptor.generateDescription(batchOutputPath, batch, batchesOutput);
			]
		
			batchesOutput.append("============================================")
			batchesOutput.append(System.getProperty("line.separator"));
		]
	
		if(customBatch === null) {
			outputExperimentSummary(batches, outcomePath, moptFile, batchesOutput)
		}
	}
	
	def void outputExperimentSummary(List<MDEOBatch> batches, Path outcomePath, Path moptFile, StringBuilder batchesOutput){
		
		val averageTime = batches.fold(0.0, [acc, batch | acc + batch.duration])/batches.length
		val averageObjectiveValues = new HashMap<String, Double>();
		var formatter = new SimpleDateFormat("HH:mm:ss.SSS");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		for(var i = 0; i < batches.size; i++){

			val batch = batches.get(i);			
			val sumBatchObjectives = new HashMap<String, Double>();
			
			batch.solutions.forEach[solution | 
				solution.formattedObjectives.forEach[p1, p2| 
					if(sumBatchObjectives.containsKey(p1)) {
						sumBatchObjectives.put(p1, sumBatchObjectives.get(p1) + p2)
					} else {
						sumBatchObjectives.put(p1, p2)	
					}
				]
			]
			
			sumBatchObjectives.forEach[p1, p2 |
				if(averageObjectiveValues.containsKey(p1)){
					averageObjectiveValues.put(p1, averageObjectiveValues.get(p1) + p2 / batch.solutions.size)
				} else {
					averageObjectiveValues.put(p1, p2);	
				}
			]
		}
				
		val infoWriter = new PrintWriter(new File(outcomePath + "overall-results.txt"))
		
		
		infoWriter.println(String.format("Average experiment time: %s", formatter.format(averageTime)))
		infoWriter.println()
		
		//TODO Remove or replace this with something more telling about the overall results	
		averageObjectiveValues.forEach[p1, p2|
			infoWriter.println(String.format("Average value for %s objective: %s", p1, averageObjectiveValues.get(p1)/batches.size))
		]
	
		infoWriter.println(batchesOutput.toString)
		
		infoWriter.close
	}
	
	/**
	 * Load a set of descriptors that we would like to run on the produced experiments data.
	 * They perform tasks such as generating parseable results, serializing models and generated
	 * mutation operators.
	 */
	private def List<ResultsDescriptor> loadDescriptors(){
		
		var descriptors = new ArrayList<ResultsDescriptor>();
		
		descriptors.add(new TextDescriptor())
		descriptors.add(new MOEAObjectivesOutputDescriptor())
		descriptors.add(new ParetoChartOutputDescriptor())
		descriptors.add(new BatchReportsDescriptor(this.moptConfiguration))
		descriptors.add(new GeneratedMutationOperatorsDescriptor())
		//descriptors.add(new HypervolumeDescriptor())
		descriptors.add(new ExperimentCSVSerializer())
		descriptors.add(new AccumulatorSerialiser())
		descriptors.add(new SystemInformationDescriptor())
		descriptors.add(new MoptSpecSerialiser(this.moptFile))
		return descriptors;
	}
	
	//TODO Split this from the normal run results
	def saveParameterSearchOutcome(MDEOParameterSearchResult outcome) {
		
		val infoWriter = new PrintWriter(Paths.get(outcome.parameterSearchOutputPath, "overall-results.txt").toFile)
		
		infoWriter.println("Parameter search results")
		infoWriter.println()
		infoWriter.println("Number of configurations evaluated: " + outcome.numberOfCandidatesCompleted)
		
		infoWriter.println("Best candidate")
		infoWriter.println("============================================")
		describeResult(infoWriter, outcome.bestResultReference.result)
		infoWriter.println
		
		infoWriter.println("All candidates")
		infoWriter.println("============================================")
		outcome.resultReferences.forEach[ resultReference | 
			describeResult(infoWriter, resultReference.result)
		]
		
		infoWriter.close();
	}
	
	def void describeResult(PrintWriter printWriter, OptimizationResult result) {
		
		var mdeoCandidate = result.resultReference.resultModel as MDEOHyperparametersConfiguration
		var mdeoBatchResults = result.modelSpecificResults as Map<Integer, SearchResult>
		
		printWriter.println(String.format("Candidate id: %s", result.index))
		printWriter.println(String.format("Candidate score: %s", result.score))
		printWriter.println(String.format("Evolutions parameter: %s", mdeoCandidate.evolutions))
		printWriter.println(String.format("Populations parameter: %s", mdeoCandidate.populationSize))
		printWriter.println(String.format("Total runtime: %s", getCandidateRuntime(result)))
		printWriter.println(String.format("Total batches: %s", mdeoBatchResults.size))
		printWriter.println
		//TODO Add more score statistics best, worst, std-dev
	}
	
	def String getCandidateRuntime(OptimizationResult result){
		
		var formatter = new SimpleDateFormat("HH:mm:ss.SSS");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		return formatter.format(result.candidateInfo.endTime - result.candidateInfo.startTime)
		
	}
}