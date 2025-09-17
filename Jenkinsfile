pipeline{
  agent any
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
