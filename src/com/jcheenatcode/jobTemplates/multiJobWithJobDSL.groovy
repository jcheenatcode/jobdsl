@Grab(group='org.codehaus.groovy', module='groovy-yaml', version='3.0.9')
import groovy.yaml.YamlSlurper

def yamlFile = readFileFromWorkspace('config/jobs.yaml')
println yamlFile

def datas;

datas = new YamlSlurper().parseText(yamlFile)
println datas.toString()

def jobs = datas.jobs;

jobs.eachWithIndex { item, idx ->
    job("example_${item.project}") {
        steps {
            batchFile('echo Hello World!')
        }
    }
}