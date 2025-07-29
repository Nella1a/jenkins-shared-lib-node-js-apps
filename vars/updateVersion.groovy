#! /usr/bin/env groovy

def call () {
  echo "Update version ... "
  def version = sh(
                script: "node -p \"require('./package.json').version\"",
                returnStdout: true
              ).trim()
  return version
}
