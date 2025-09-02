#! /usr/bin/env groovy

def call(String IMAGE_TAG, String ec2Instance, String scriptName) {
  echo "Deploying to AWS EC2 Instance ..."

  sshagent(['ec2-server-key']) {
    sh "ssh -o StrictHostKeyChecking=no ${ec2Instance} chmod +x /home/ec2-user/${scriptName}"
    sh "ssh -o StrictHostKeyChecking=no ${ec2Instance} bash ./${scriptName} ${IMAGE_TAG}"
  }

}
