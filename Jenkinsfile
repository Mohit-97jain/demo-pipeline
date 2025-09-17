pipeline{
  agent any
  tools {
        maven 'Maven'   // same name you gave in Jenkins config
    }
  stages{
    stage("build"){
      steps{
        bat "mvn clean package"

      }
    }
    stage("run"){
      steps{
echo "running the application"

      }
    }
  }

}
