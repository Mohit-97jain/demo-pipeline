pipeline {
    agent any
    tools {
        maven 'Maven'   // Jenkins tool config name
    }
    environment {
        DOCKERHUB_CREDENTIALS = "dckr_pat_4qO2ugWRfbf2mUKxL6-FFPOp-Qg"
        IMAGE_NAME = "mj36172/spring-mongo-app"
    }

    stages {
        stage("Build with Maven") {
            steps {
                bat "mvn clean package -DskipTests"
            }
        }

        stage("Build Docker Image") {
            steps {
                script {
                    app = docker.build("${IMAGE_NAME}:${BUILD_NUMBER}")
                }
            }
        }

        stage("Push to DockerHub") {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', "${DOCKERHUB_CREDENTIALS}") {
                        app.push()                   // push version tag
                        app.push("latest")           // push latest tag
                    }
                }
            }
        }

        stage("Run App") {
            steps {
                echo "Application would be deployed/run here..."
            }
        }
    }
}
