pipeline {
    agent any
    tools {
        maven 'Maven3'
        jdk 'Java'
    }
    options {
        timestamps()
    }
    stages{
        stage('Checkout Code'){
            steps{
               checkout([$class: 'GitSCM', branches: [[name: '*/${Environment}']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/chetan096/nagp-biannual-devops']]])
              }
            }
        stage('Run Unit Tests'){
            steps {
                bat 'mvn -f nagp-assignment-devops/pom.xml test'
            }
        }
        stage('Sonar Analysis'){
            steps{
                withSonarQubeEnv('Test_Sonar'){
                  bat 'mvn -f nagp-assignment-devops/pom.xml sonar:sonar'
                }
            }
        }
        stage('Build'){
             steps{
                bat 'mvn -f nagp-assignment-devops/pom.xml clean install'
            }
        }
        stage('Build Docker Image'){
            steps{
                bat 'docker build -t 3147181/nes-product:%BUILD_NUMBER% nagp-assignment-devops'
            }
        }
        stage('Pre Container Check'){
            steps{
               bat """
               for /f %%i in ('docker ps -aqf "name=^nes-product"') do set containerid=%%i
               echo %containerid%
               IF "%containerid%" == "" (
                echo 'No container running'
               ) ELSE (
                 docker stop %containerid%
                 docker rm -f %containerid%
               )
               """
            }
        }
        stage('Docker Deployment'){
            steps {
                bat 'docker run -d -p 8083:9090 --name nes-product 3147181/nes-product:%BUILD_NUMBER%'
            }
        }
    }
    post {
        always {
            junit 'nagp-assignment-devops/target/surefire-reports/*.xml'
        }
    }
}