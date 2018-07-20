package uk.ac.kcl.optimisation.moea.problem

import org.moeaframework.core.EvolutionaryAlgorithm
import org.moeaframework.core.Problem
import org.moeaframework.core.spi.ProblemProvider
import org.moeaframework.core.spi.ProviderNotFoundException
import uk.ac.kcl.optimisation.SolutionGenerator
import uk.ac.kcl.optimisation.moea.algorithms.MoeaOptimisationAlgorithmProvider

class MoeaMdeoProblemProvider extends ProblemProvider {
	
	private SolutionGenerator solutionGenerator;
	private EvolutionaryAlgorithm algo

	new(SolutionGenerator solutionGenerator, MoeaOptimisationAlgorithmProvider referenceSet){
		this.solutionGenerator = solutionGenerator;
		this.algo = (referenceSet.algo as EvolutionaryAlgorithm);
	}

	override getProblem(String name) {
		
		if(name.equals("problemName")){
			try {
				var problem = new MoeaOptimisationProblem(solutionGenerator)
		
				return problem as Problem
			} catch (ClassNotFoundException e) {
				return null;
			} catch (Exception e) {
				throw new ProviderNotFoundException(name, e);
			}
		}
		
	}
	
	override getReferenceSet(String name) {
		return this.algo.result;
	}
	
}