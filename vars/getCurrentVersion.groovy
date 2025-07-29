#! /usr/bin/env groovy

def call(){
  echo ' Capture current version from package.json ...'

  def version = sh(
                script: "node -p \"require('./package.json').version\"",
                returnStdout: true
              ).trim()

return version
}