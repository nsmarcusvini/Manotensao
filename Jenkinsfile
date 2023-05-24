pipeline {
    agent any

    stages {
        stage('Deploy') {
            steps {
                script {
                        sh "docker pull nsmarcusvini/mano-tensao:latest"
 				sh "docker run -d -p 80:8090 nsmarcusvini/mano-tensao:latest"
				sh "git pull main"
                }
            }
        }
    }
}