@Grab(group='org.codehaus.groovy', module='groovy-yaml', version='3.0.9')
import groovy.yaml.YamlSlurper

def yamlFile = readFileFromWorkspace('jobs.yaml')
println yamlFile

// Create YAML file.
// def yamlFile = new File("./jobs.yaml")
def datas;

datas = new YamlSlurper().parseText(yamlFile)
println datas.toString()

String[] jobs = ["ex_1", "ex_2", "ex_3"]


jobs.each { item, idx ->
    job("example_${item}") {
        steps {
            batchFile('echo Hello World!')
        }
    }
}