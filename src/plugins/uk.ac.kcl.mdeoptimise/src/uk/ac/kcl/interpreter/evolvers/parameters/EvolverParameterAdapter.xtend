package uk.ac.kcl.interpreter.evolvers.parameters

import uk.ac.kcl.mdeoptimise.EvolverParameter
import org.eclipse.xtend.lib.annotations.Accessors

class EvolverParameterAdapter {

	public String name;
	public String function;
	public String parameter;

	new(EvolverParameter evolverParameterSpec) {
		name = evolverParameterSpec.name;
		
		if(evolverParameterSpec.function != null){
			function = evolverParameterSpec.function.name;
			parameter = evolverParameterSpec.function.parameter;	
		} else {
			function = evolverParameterSpec.customFunction;
		}
	}
}