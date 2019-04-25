package uk.ac.kcl.mdeoptimiser.libraries.core.optimisation.hyperparameter.arbiter

import java.util.ArrayList
import java.util.Collections
import java.util.HashMap
import java.util.Map
import org.deeplearning4j.arbiter.optimize.api.ParameterSpace

class MDEOParameterSpace implements ParameterSpace {

	Map<String, ParameterSpace> leaves = new HashMap<String, ParameterSpace>();

	/**
	 * Returns a list of all the parameter spaces to be optimised.
	 * 
	 * @return list of configured parameterSpaces
	 */
	override collectLeaves() {
		return this.leaves.entrySet.fold(new ArrayList<ParameterSpace>) [ list, value |
			list.add(value.value)
			return list
		];
	}

	/**
	 * This should return a list of nested parameter spaces. Not something we use in MDEO
	 */
	override getNestedSpaces() {
		return Collections.EMPTY_MAP
	}

	override MDEOHyperparametersConfiguration getValue(double[] parameters) {


		this.leaves.get("populationSize").indices = #[0]
		this.leaves.get("evolutions").indices = #[1]

		var population = leaves.get("populationSize").getValue(parameters) as Integer
		var evolutions = leaves.get("evolutions").getValue(parameters) as Integer

		// Add setters for algorithm parameters
		return new MDEOHyperparametersConfiguration(population, evolutions);
	}

	override isLeaf() {
		return false;
	}

	override numParameters() {
		return leaves.entrySet.length;
	}

	/**
	 * The parameter order index for the generation function
	 */
	override setIndices(int... parameterIndices) {
	}

	// TODO: Order is important
	def void setPopulationSize(ParameterSpace parameterSpace) {
		this.leaves.put("populationSize", parameterSpace)
	}

	def void setEvolutions(ParameterSpace parameterSpace) {
		this.leaves.put("evolutions", parameterSpace)
	}
}