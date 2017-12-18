pipeline {
    agent any
    environment{
        TEST_ENV = 'test'
    }
    stages{
        stage('Build'){
            steps{
                echo "Building version"
                sh "./mvnw clean"
            }
        }
        stage('Deploy'){
            steps{
                echo "Deploying version"
            }
        }
        stage('Performance'){
            steps{
                echo "Running performance"
            }
        }
        stage('Deploy Production'){
            steps{
                echo "Deploying in production"
            }
        }
    }
    post {
        always {
            echo 'pipeline executed succesfully'
        }
    }
}