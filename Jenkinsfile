pipeline{
  agent any
  stages{
    stage("build"){
      steps{
sh "mvn clean package"

      }
    }
    stage("run"){
      steps{
echo "running the application"

      }
    }
  }

}
