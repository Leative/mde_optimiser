package uk.ac.kcl.ui.output

import java.util.List
import uk.ac.kcl.optimisation.moea.problem.MoeaOptimisationSolution
import java.util.Iterator
import org.eclipse.emf.henshin.model.Module
import org.eclipse.emf.ecore.EPackage
import java.util.Map
import org.moeaframework.Instrumenter
import org.moeaframework.core.NondominatedPopulation
import org.moeaframework.core.Solution

class MDEOBatch {
	
	public Integer id;
	public long duration;
	private List<MoeaOptimisationSolution> solutions;
	public Map<EPackage, List<Module>> generatedRules;
	public Instrumenter instrumenter;
	public boolean singleBatch;
	
	new(Integer id, long duration, Instrumenter outcome, Map<EPackage, List<Module>> generatedRules, boolean singleBatch){
		this.id = id;
		this.duration = duration;
		this.instrumenter = outcome;
		this.generatedRules = generatedRules;
		this.singleBatch = singleBatch
	}
	
	new(Integer id, long duration, Instrumenter outcome, Map<EPackage, List<Module>> generatedRules){
		this(id, duration, outcome, generatedRules, false)
	}
	
	def List<MoeaOptimisationSolution> getSolutions(){
		
		if(this.solutions !== null){
			return this.solutions;
		}
		
		var acumulator = instrumenter.lastAccumulator
		var approximationSet = (acumulator.get("Approximation Set", acumulator.size("Approximation Set") - 1) as List<Solution>) 
		this.solutions = getOptimisationOutcomeObjects(new NondominatedPopulation(approximationSet)).toList
		
		return this.solutions
	}
	
	def Iterator<MoeaOptimisationSolution> getOptimisationOutcomeObjects(NondominatedPopulation population){
		return population.iterator.map[ p | (p as MoeaOptimisationSolution)]
	}	
}