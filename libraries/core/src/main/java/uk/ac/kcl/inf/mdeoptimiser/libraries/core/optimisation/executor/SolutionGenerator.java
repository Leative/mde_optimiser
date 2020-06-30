package uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.executor;

import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.henshin.model.Unit;
import uk.ac.kcl.inf.mdeoptimiser.languages.mopt.Optimisation;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IModelProvider;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.evolvers.parameters.EvolverParametersFactory;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.henshin.HenshinExecutor;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.operators.adaptation.MutationStepSizeStrategy;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.operators.crossover.CrossoverStrategy;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.operators.crossover.CrossoverStrategyFactory;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.operators.mutation.MutationStrategy;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.operators.mutation.MutationStrategyFactory;

public class SolutionGenerator {

  EPackage theMetamodel;

  Optimisation optimisationModel;

  IModelProvider initialModelProvider;

  MutationStrategy mutationStrategy;
  CrossoverStrategy crossoverStrategy;

  HenshinExecutor henshinExecutor;

  MutationStepSizeStrategy mutationStepSizeStrategy;

  public SolutionGenerator(
      Optimisation model,
      List<Unit> breedingOperators,
      List<Unit> mutationOperators,
      IModelProvider modelProvider,
      EPackage metamodel) {
    this.optimisationModel = model;
    this.initialModelProvider = modelProvider;
    this.theMetamodel = metamodel;
    this.henshinExecutor =
        new HenshinExecutor(
            new EvolverParametersFactory(model.getSearch().getEvolvers()),
            mutationOperators,
            breedingOperators,
            model.getSolver());
  }

  /**
   * Set the configured mutation step size strategy to use when generating solutions from this
   * solution generation using mutation.
   *
   * @param mutationStepSizeStrategy an instance of the configured strategy
   */
  public void setMutationStepSizeStrategy(MutationStepSizeStrategy mutationStepSizeStrategy) {
    this.mutationStepSizeStrategy = mutationStepSizeStrategy;
  }

  // TODO IOC
  public MutationStrategy getMutationStrategy() {

    if (this.mutationStrategy == null) {
      this.mutationStrategy =
          new MutationStrategyFactory(
                  henshinExecutor,
                  this.mutationStepSizeStrategy,
                  optimisationModel.getSolver().getAlgorithm())
              .getStrategy();
    }

    return this.mutationStrategy;
  }

  public CrossoverStrategy getCrossoverStrategy() {

    if (this.crossoverStrategy == null) {

      // TODO- When adding the rule chain, implement the correct strategies here
      this.crossoverStrategy = new CrossoverStrategyFactory(henshinExecutor).getStrategy(null);
    }

    return this.crossoverStrategy;
  }

  /**
   * This will produce a lazy iteration of possible initial solutions
   *
   * @return list of initial list of models
   */
  public Iterator<Solution> getInitialSolutions() {
    return initialModelProvider.initialModels(theMetamodel);
  }

  /** Returns the optimisation model to use inside the moea problem/solution */
  public Optimisation getOptimisationModel() {
    return optimisationModel;
  }

  /**
   * Produces two offspring from the two parents provided in the parameter.
   *
   * @param parents a list of two parent models
   * @returns a list of results offspring
   */
  public List<Solution> breed(List<Solution> parents) {
    return this.getCrossoverStrategy().breed(parents);
  }

  /**
   * Produce a new solution from the given one using one of the evolvers defined in the optimisation
   * model. This will
   *
   * @param model Solution model
   */
  public Solution mutate(Solution model) {
    return this.getMutationStrategy().mutate(model);
  }
}
