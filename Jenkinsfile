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
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t demo-app .'
            }
        }

        stage('Docker Run') {
            steps {
                sh 'docker stop demo-app || true'
                sh 'docker rm demo-app || true'
                sh 'docker run -d --name demo-app -p 8080:8080 demo-app'
            }
        }
    }
}
