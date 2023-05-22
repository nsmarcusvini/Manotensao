pipeline {
    agent any

    stages {
        stage('Deploy') {
            steps {
                script {
                        sh "docker pull nsmarcusvini/mano-tensao:latest"
 				sh "docker run -d -p 80:8080 nsmarcusvini/mano-tensao:latest"
                }
            }
        }
    }
}