#! /usr/bin/env groovy

def all() {
  echo "Docker login ..."
  withCredentials([usernamePassword(credentialsId: 'cred-docker', passwordVariable: 'PASS', usernameVariabel: 'USER')]){
    sh 'echo "$PASS" | docker login -u "$USER" --password-stdin'
  }
}