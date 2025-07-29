#! /usr/bin/env groovy

def call(String imageName) {
  echo "Building the docker image"
  sh "docker build -t ${imageName} ."
}
