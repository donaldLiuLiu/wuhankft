pipeline {
    agent any
    stages {
        stage("start") {
            steps {
                echo "Jenkins 世界"
            }
        }
        stage("build") {
            steps {
                sh 'ls -las'
            }
        }
        /*stage("build") {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }*/
        /*stage("run-local") {
            steps {
                sh 'java -jar wuhankft-0.0.1-SNAPSHOT.jar'
            }
        }*/
    }
}