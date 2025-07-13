pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/ManuRoy/demo.git'
            }
        }

        stage('Build') {
            steps {
                bat 'demo\\mvnw.cmd clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t demo-app demo'
            }
        }

        stage('Docker Run') {
            steps {
                bat 'docker stop demo-app || echo not running'
                bat 'docker rm demo-app || echo not existing'
                bat 'docker run -d --name demo-app -p 8080:8080 demo-app'
            }
        }
    }
}
