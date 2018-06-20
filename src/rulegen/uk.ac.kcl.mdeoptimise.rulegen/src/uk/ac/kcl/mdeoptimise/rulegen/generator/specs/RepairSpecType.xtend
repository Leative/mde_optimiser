package uk.ac.kcl.mdeoptimise.rulegen.generator.specs

enum RepairSpecType {
	
	//Create node and generate a NAC if required
	CREATE,
	CREATE_LB_REPAIR,
	CREATE_LB_REPAIR_MANY,
	
	//Delete node and generate a PAC if required
	DELETE,
	DELETE_LB_REPAIR,
	DELETE_LB_REPAIR_MANY,
	
	//Edge
	ADD,
	REMOVE,
	CHANGE,
	SWAP
}