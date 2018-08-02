/*
 * generated by Xtext 2.10.0
 */
package uk.ac.kcl.ui.handler

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import uk.ac.kcl.mdeoptimise.Optimisation

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class MDEOptimiseGenerator extends AbstractGenerator {

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
	val root = resource.allContents.head as Optimisation;

	if(root !== null){
		println(root.problem.metamodel)
		println(root.problem.basepath)
	}

//		fsa.generateFile('greetings.txt', 'People to greet: ' + 
//			resource.allContents
//				.filter(typeof(Greeting))
//				.map[name]
//				.join(', '))
	}
}
