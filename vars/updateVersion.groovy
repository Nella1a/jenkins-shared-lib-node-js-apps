#! /usr/bin/env groovy

call def () {
  echo "Update version ... "
  def version = sh(
                script: "node -p \"require('./package.json').version\"",
                returnStdout: true
              ).trim()
  return version
}