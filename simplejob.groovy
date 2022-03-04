pipelineJob('example') {
    properties {
        buildDiscarder {
            strategy {
                logRotator {
                    daysToKeepStr('60')
                    numToKeepStr('60')
                    artifactDaysToKeepStr('-1')
                    artifactNumToKeepStr('-1')
                }
            }
        }
        githubProjectProperty {
            projectUrlStr('')
            displayName('')
        }

        parametersDefinitionProperty {
            parameterDefinitions {
				stringParameterDefinition {
                    name('module_name')
                    description('module name description')
                    defaultValue('Test')
                    trim(false)
                }
				stringParameterDefinition {
                    name('module_name2')
                    description('module name 2 description')
                    defaultValue('Test 2')
                    trim(true)
                }
            }
        }
    }
}

// job('example') {
//   steps {
//     batchFile('echo Hello World!')

//     echo 'Hello, world'
//     sayHello 'Dave'

//     echo 'The value of foo is : ' + GlobalVars.foo
//   }
// }