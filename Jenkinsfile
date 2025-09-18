pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-credentials') 
        IMAGE_NAME = "mj36172/spring-mongo-app"
    }

    tools {
        maven 'Maven'   // Define Maven from Jenkins global tools
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Mohit-97jain/spring'   // your repo
            }
        }

        stage('Build with Maven') {
            steps {
                bat 'mvn clean package -DskipTests'  // use "sh" if Linux agent
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${IMAGE_NAME}:${env.BUILD_NUMBER}")
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS) {
                        docker.image("${IMAGE_NAME}:${env.BUILD_NUMBER}").push()
                        docker.image("${IMAGE_NAME}:${env.BUILD_NUMBER}").push("latest")
                    }
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
