@Grab(group='org.codehaus.groovy', module='groovy-yaml', version='3.0.9')
import groovy.yaml.YamlSlurper
import jenkins.model.Jenkins

def dirVal = new File('.').absolutePath
println dirVal

def workspace = manager.build.getEnvVars()["WORKSPACE"]
println workspace;

def envVars = Jenkins.instance.getGlobalNodeProperties()[0].getEnvVars() 
println envVars.toString()

// Create YAML file.
def yamlFile = new File("./jobs.yaml")
def datas;

yamlFile.withReader { reader ->
    // Use parse method of YamlSlurper.
    datas = new YamlSlurper().parse(reader)
    
    echo datas.toString()
}


String[] jobs = ["ex_1", "ex_2", "ex_3"]


jobs.each { item, idx ->
    job("example_${item}") {
        steps {
            batchFile('echo Hello World!')
        }
    }
}