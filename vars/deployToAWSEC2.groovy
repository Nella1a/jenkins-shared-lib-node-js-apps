#! /usr/bin/env groovy

def call(String imgName, String port, String hostIp, String userName) {
  echo "Deploying to AWS EC2 Instance ..."
  def dockerCmd = "docker run -d -p ${port}:${port} ${imgName}"
  sshagent(['ec2-server-key']){
    sh "ssh -o StrictHostKeyChecking=no ${userName}@${hostIp} ${dockerCmd}"
  }

}