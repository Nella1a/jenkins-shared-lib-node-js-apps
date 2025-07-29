#! /usr/bin/env groovy

def call(String imageName) {
  echo 'Push image to docker ... '
  sh "docker push ${imageName}"
}