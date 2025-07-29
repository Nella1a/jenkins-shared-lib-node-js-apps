#! /usr/bin/env groovy

def call(String currentVersion, String updatedVersion, String gitRepo) {
  echo "Commit changes to github ... "

  withCredentials([usernamePassword(credentialsId: 'github-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]){

  sh 'git config user.name "jenkins"'
  sh 'git config user.email "jenkins@example.com"'
  sh "git remote set-url origin https://${USER}:${PASS}@${gitRepo}"
  sh 'git add .'
  sh "git commit -m \"Updated image version from ${currentVersion} to ${updatedVersion}\""
  sh 'git push origin HEAD:main'
  }

}
