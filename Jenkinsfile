pipeline {
    agent any
    stages {
        stage("start") {
            steps {
                echo "Jenkins 世界"
            }
        }
        /*如果windows机上运行Jenkins，可以执行CMD命令*/
        stage("build") {
            steps {
                bat 'dir'
                bat 'mvn -B -DskipTests clean package'
                bat 'java -jar target/wuhankft-0.0.1-SNAPSHOT.jar'
            }
        }
        /*windows机上Jenkins将不能执行shell指令*/
        /*stage("build") {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }*/
        /*stage("run-local") {
            steps {
                sh 'java -jar target/wuhankft-0.0.1-SNAPSHOT.jar'
            }
        }*/
    }
}