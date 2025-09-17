pipeline{
  agent any
  tools {
        maven 'Maven'   // same name you gave in Jenkins config
    }
 environment {
        
        IMAGE_NAME = "Pipeline:v1"
    }
  
  stages{
    stage("build"){
      steps{
        bat "mvn clean package"

      }
    }
    stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${IMAGE_NAME}:${env.BUILD_NUMBER}")
                }
            }
        }
    stage("run"){
      steps{
echo "running the application"

      }
    }
  }

}
