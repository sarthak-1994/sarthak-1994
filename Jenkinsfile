pipeline {

      agent any
      parameters {
          string(name: 'suiteXmlFile', defaultValue: 'testng.xml', description: 'TestNG XML file name')
      }

    environment {
        MAVEN_OPTS = "-Dmaven.test.failure.ignore=false"
    }

    tools {
        maven 'Maven 3.8.6'  // Ensure this matches your Jenkins Maven installation name
        jdk 'jdk-17'         // Ensure this matches your Jenkins JDK installation name
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build & Test') {
            steps {
                 sh "mvn clean test -DsuiteXmlFile=${params.suiteXmlFile}"
            }
        }
        stage('Archive Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
                archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
            }
        }
    }
    post {
        always {
            cleanWs()
        }
    }
}