package uk.ac.kcl.optimisation.moea

import org.moeaframework.core.Variation
import org.moeaframework.core.Solution
import uk.ac.kcl.optimisation.SolutionGenerator

class MoeaOptimisationVariation implements Variation {
	
	private SolutionGenerator solutionGenerator;
	
	new(SolutionGenerator solutionGenerator){
		this.solutionGenerator = solutionGenerator;
	}
	
	//USed to evolve a solution using the henshin evolvers
	override evolve(Solution[] parents) {
		
		var parentSolution = parents.get(0).copy() as MoeaOptimisationSolution;
		
		parentSolution.setModel(solutionGenerator.evolveModel(parentSolution.model));
		
		#[parentSolution]

	}
	
	override getArity() {
		return 1;
	}
	
}