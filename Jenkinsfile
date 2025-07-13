pipeline {
    agent any

    environment {
        DOCKER_BUILDKIT = '1'
    }

    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/ManuRoy/demo.git'
            }
        }

        stage('Build') {
            steps {
                bat 'cd demo && mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t demo-app -f Dockerfile demo'
            }
        }

        stage('Docker Run') {
            steps {
                // Stop and remove existing container if any
                bat 'docker rm -f demo-container || echo "Container not running"'

                // Run the new container from the built image
                bat 'docker run -d -p 8081:8080 --name demo-container demo-app'
            }
        }
    }
}
