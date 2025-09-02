#! /usr/bin/env groovy

def call(String version) {
  // bump the version of the npm package and don't commit

  sh "npm version ${version} --git-tag-version false"

}
