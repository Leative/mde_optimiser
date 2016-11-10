package uk.ac.kcl.optimisation.moea

import org.eclipse.emf.ecore.EObject
import org.moeaframework.core.Solution
import uk.ac.kcl.optimisation.SolutionGenerator

class MoeaOptimisationSolution extends Solution {

	SolutionGenerator solutionGenerator
	
	private EObject model;
	
	new(MoeaOptimisationSolution moeaOptimisationSolution){
		super(moeaOptimisationSolution.numberOfVariables, moeaOptimisationSolution.numberOfObjectives)
		this.model = moeaOptimisationSolution.getModel
		this.solutionGenerator = moeaOptimisationSolution.getSolutionGenerator
		
		for(var i = 0; i < moeaOptimisationSolution.numberOfVariables; i++){
			this.setVariable(0, new MoeaOptimisationVariable(moeaOptimisationSolution.getModel(), solutionGenerator))
		}
	}
	
	new(int numberOfVariables, int numberOfObjectives) {
		super(numberOfVariables, numberOfObjectives)
	}
	
	new(SolutionGenerator solutionGenerator){
		
		//1 variable - our model, fitness function objectives
		this(1, solutionGenerator.optimisationModel.objectives.size())
		
		this.solutionGenerator = solutionGenerator;
		setModel(solutionGenerator.initialSolutions.head)
		//Set variables with initial models to be used in initial population generation
		this.setVariable(0, 
			new MoeaOptimisationVariable(getModel(), solutionGenerator)
		)

	}
	
	override MoeaOptimisationSolution copy(){
		new MoeaOptimisationSolution(this);
	}
	
	def EObject getModel(){
		this.model;
	}
	
	def void setModel(EObject model) {
		this.model = model
	}
	
	def SolutionGenerator getSolutionGenerator(){
		return this.solutionGenerator
	}
	
	def void setSolutionGenerator(SolutionGenerator solutionGenerator) {
		this.solutionGenerator = solutionGenerator;
	}
	
}