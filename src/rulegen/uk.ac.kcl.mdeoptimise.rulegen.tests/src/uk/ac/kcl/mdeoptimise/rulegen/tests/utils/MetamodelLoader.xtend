package uk.ac.kcl.mdeoptimise.rulegen.tests.utils

import org.eclipse.emf.henshin.model.resource.HenshinResourceSet
import org.eclipse.emf.ecore.EPackage
import uk.ac.kcl.mdeoptimise.Optimisation
import java.util.List
import uk.ac.kcl.mdeoptimise.rulegen.metamodel.Multiplicity
import static org.junit.Assert.*
import static org.mockito.Mockito.*
import uk.ac.kcl.mdeoptimise.BasePathSpec
import uk.ac.kcl.mdeoptimise.MetaModelSpec
import java.util.LinkedList

class MetamodelLoader {
	
	private HenshinResourceSet henshinResourceSet;
	private EPackage theMetamodel
	Optimisation model;
	
	def getResourceSet() {
        if (henshinResourceSet == null) {
            henshinResourceSet = new HenshinResourceSet(model.basepath.location)
        }

        henshinResourceSet
    }

    def getMetamodel() {
        if (theMetamodel == null) {
            theMetamodel = getResourceSet.registerDynamicEPackages(model.metamodel.location).head
        }

        theMetamodel
    }
    
    def EPackage fakeOptimisationModel(String metamodelName, List<Multiplicity> multiplicities){
    	this.model = mock(Optimisation)
		var basepath = mock(BasePathSpec);
		var metamodel = mock(MetaModelSpec);
		when(basepath.location).thenReturn("src/resources/");
		when(metamodel.location).thenReturn(metamodelName)
		
		when(model.basepath).thenReturn(basepath)
		when(model.metamodel).thenReturn(metamodel)
		
		
		return new MetamodelGenerator(getMetamodel()).generate(multiplicities)
    }
    
    def EPackage fakeCraMetamodel(){
    	
		var multiplicities = new LinkedList<Multiplicity>();

    	return this.fakeOptimisationModel("architectureCRA.ecore", multiplicities);
    }
    
    def EPackage fakeSprintPlaningMetamodel(){
    	
    	var multiplicities = new LinkedList<Multiplicity>();
    	
    	return this.fakeOptimisationModel("SprintPlanning.ecore", multiplicities);
    }
    
    def EPackage fakeOrchestrationMetamodel(){
    	
    	var multiplicities = new LinkedList<Multiplicity>();
		
    	return this.fakeOptimisationModel("OrchestrationMM.ecore", multiplicities);
    }
    
    def EPackage fakeNRPMetamodel(){
    	
    	var multiplicities = new LinkedList<Multiplicity>();
		
    	return this.fakeOptimisationModel("nextReleaseProblem.ecore", multiplicities);
    }
    
    def EPackage fakeGenericMetamodel(){
    	
    	var multiplicities = new LinkedList<Multiplicity>();
		
    	return this.fakeOptimisationModel("rulegen.ecore", multiplicities);
    }
}