@Library('mylibrary') _

import com.jcheenatcode.GlobalVars

String[] jobs = ["ex_1", "ex_2", "ex_3"]

jobs.each { item, idx ->
    job("example_${item}") {
        steps {
            batchFile('echo Hello World!')
        }
    }
}