pipeline {
  agent any
  stages {
    stage('Deploy to maven') {
      steps {
        sh 'mvn clean deploy'
      }
    }

  }
}