pipeline{
  agent any
  tools {
        maven 'Maven'   // same name you gave in Jenkins config
    }
 environment {
    DOCKERHUB_CREDENTIALS = "dckr_pat_4qO2ugWRfbf2mUKxL6-FFPOp-Qg" // must be a valid ID
    IMAGE_NAME = "mj36172/spring-mongo-app"  // no spaces or special chars
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
    stage("push image into docker hub"){
      steps{
        script{
           docker.withRegistry('https://index.docker.io/v1/', 'dckr_pat_4qO2ugWRfbf2mUKxL6-FFPOp-Qg') {
                        def app = docker.build("mj36172/spring-mongo-app")
                        app.push()
                    }
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
