## MDE Optimiser

This is the main repository for the MDEOptimiser tool.

### Build status

DEV Build

![DEVELOP branch build status](https://travis-ci.org/mde-optimiser/mde_optimiser.svg?branch=develop)

MASTER Build

![MASTER branch build status](https://travis-ci.org/mde-optimiser/mde_optimiser.svg?branch=master)

### Installation URLs

Use Eclipse Version 2019-03

Eclipse Development Version:
http://mde-optimiser.github.io/mde_optimiser/downloads/p2/develop/



## Notes for new build structure

The MDEOptimiser parent pom file is located in the build/maven directory. Navigate to this directory to import the code into eclipse.

The Eclipse plugin parent pom file is dependent on a successfull MDEOptimiser maven build. The pom file for the Eclipse UI is located in the interfaces/eclipse/src directory.

All Maven projects are organised in a single pom file. ANT is used to build these projects first, then the Eclipse interface is built by using the published artifacts from this build.

Build order:

1. Maven projects are compiled and deployed to a maven repository. Eclipse bundles are loaded as a maven repository from the repositories/output directory
2. The maven repository is converted to a P2 repository and the output is stored in repositories/output
3. The Eclipse projects are built. Maven artifacts are loaded as Eclipse bundles from the P2 repository.


## To create a new project

### Using Java Only

mvn archetype:generate \
	-DgroupId={project-packaging} \
	-DartifactId={project-name} \
	-DarchetypeArtifactId=maven-archetype-quickstart \
	-DinteractiveMode=false


Some other maven archetypes:

mvn archetype:generate \ 
-DgroupId={group-id} \
-DartifactId={artifact-id} \
-DarchetypeArtifactId=maven-archetype-quickstart \
-DarchetypeVersion=1.4 \
-DinteractiveMode=false 

mvn archetype:generate \
-DgroupId={group-id} \
-DartifactId={artifact-id} \
-DarchetypeGroupId=com.thepracticaldeveloper \
-DarchetypeArtifactId=archetype-java-basic-tpd \ 
-DarchetypeVersion=1.0.0 \
-Djava-version=9


More Maven project configuration settings example site:
https://www.mkyong.com/maven/how-to-create-a-java-project-with-maven/

### Using Java and XTend

mvn archetype:generate
-DgroupId={project-packaging} \
-DartifactId={project-name} \
-DarchetypeGroupId=org.eclipse.xtend \
-DarchetypeArtifactId=xtend-archetype

More XTend Maven configuration settings: https://www.eclipse.org/xtend/download.html
