package uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation

import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.moea.MoeaFrameworkAlgorithmConfiguration
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.moea.SearchResult

interface IOptimisationExecutor {
	
	/**
	 * Returns an optimisation outcome as a set of objects.
	 * Maybe this should also include population information, such as objective values.
	 * TODO Look at MOEA Instrumentation?
	 */
	def SearchResult execute(MoeaFrameworkAlgorithmConfiguration moeaFrameworkAlgorithmConfiguration);
}