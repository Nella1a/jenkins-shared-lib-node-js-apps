#! /usr/bin/env groovy

def call(String imgName, String port, String hostIp, String userName) {
  echo "Deploying to AWS EC2 Instance ..."
  def dockerComposeCmd = "docker-compose -f docker-compose.yaml up --detach"
  sshagent(['ec2-server-key']) {
    sh "scp docker-compose.yaml ${userName}@${hostIp}:/home/ec2-user"
    sh "ssh -o StrictHostKeyChecking=no ${userName}@${hostIp} '${dockerComposeCmd}'"
  }

}