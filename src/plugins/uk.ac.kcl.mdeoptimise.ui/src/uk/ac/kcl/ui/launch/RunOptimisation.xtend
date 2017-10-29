package uk.ac.kcl.ui.launch 

import com.google.inject.Inject
import com.google.inject.Injector
import uk.ac.kcl.MDEOptimiseStandaloneSetup
import uk.ac.kcl.mdeoptimise.Optimisation
import uk.ac.kcl.interpreter.OptimisationInterpreter
import com.google.inject.Provider
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.common.util.URI

class RunOptimisation {
	
	static val Injector injector = new MDEOptimiseStandaloneSetup().createInjectorAndDoEMFRegistration();
	
	@Inject
	private Provider<ResourceSet> resourceSetProvider
	
	/**
	 * Static method invoked by the MDEOptimiser launch configuration
	 * @param the configured mopt file path to run the optimisation from
	 */
	def public static void main(String[] args){
		val app = injector.getInstance(RunOptimisation)
		
		if(args.length == 0){
			
			app.run("/home/alxbrd/runtime-New_configuration/test-compile", 
					"/home/alxbrd/runtime-New_configuration/test-compile/src/file.mopt")
			
		} else if(args.length == 2) {
			app.run(args.get(0), args.get(1))
		} else {
			println("Invalid number of arguments. Cannot launch optimisation.")
			println("Expecting a valid mopt file path. Received " + args)
		}
	}
	
	def void run(String moptProjectPath, String configuredMoptFilePath){
		
		if (configuredMoptFilePath == null || configuredMoptFilePath.empty) {
			println("Received a null or empty mopt file path.")
			
			return
		} else {
			
			if(resourceSetProvider == null){
				println("Empty ResourceSetProvider")
			}
			
			var resource = resourceSetProvider.get().getResource(URI.createURI(configuredMoptFilePath), true)
			var optimisationModel = resource.contents.head as Optimisation
			
			if(optimisationModel != null){
            	
				var optimisation = new OptimisationInterpreter(moptProjectPath, optimisationModel)
            	optimisation.start();
            }
			
		}
	}
}
			