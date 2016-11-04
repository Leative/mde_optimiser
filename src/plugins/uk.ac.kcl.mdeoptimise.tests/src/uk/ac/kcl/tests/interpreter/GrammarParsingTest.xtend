package uk.ac.kcl.tests.interpreter

import javax.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import uk.ac.kcl.mdeoptimise.Optimisation
import uk.ac.kcl.tests.FullTestInjector

import static org.junit.Assert.*
import org.eclipse.xtext.junit4.validation.ValidationTestHelper

@RunWith(XtextRunner)
@InjectWith(FullTestInjector)
class GrammarParsingTest {

	@Inject
	ParseHelper<Optimisation> parser
	@Inject extension ValidationTestHelper
	
	Optimisation model
	
	@Before
	def void bootstrapParser() {
		 model = parser.parse('''
			basepath <model/basepath>
			metamodel <ABC>
			fitness "ABC"
			objective minimise coupling { 
				"Valid.OclString()"
			}
			evolve using <ABC> unit "XYZ"
			evolve using <CDE> unit "LMN"
		''')
		System.out.println("123");
	}
	
	@Test
	def void assertThatThereAreNoParsingIssues() {
		model.assertNoIssues
	}
	
	@Test
	def void assertParsedOptimisationModelIsNotNull() {
		assertNotNull(model)
	}
	
	
	@Test
	def void assertBasePathIsParsed() {
		assertEquals("<model/basepath>", model.getBasepath.location)
	}
	
	@Test
	def void assertMetamodelPathIsParsed() {
		assertEquals("<ABC>", model.getMetamodel.location)
	}
	
	@Test
	def void assertObjectiveFunctionJavaPathIsParsed() {
		assertEquals("ABC", model.fitness.get(0).getFitnessClass)
	}
	
	@Test
	def void assertObjectiveFunctionOclQueryIsParsed() {
		assertEquals("minimise", model.objectives.get(0).getObjectiveType())
		assertEquals("coupling", model.objectives.get(0).getObjectiveName())
		assertEquals("Valid.OclString()", model.objectives.get(0).getOclQuery())
	}
}