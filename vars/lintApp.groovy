#!/usr/bin/env groovy

def call(){

    sh './gradlew checkstyleMain checkstyleTest --warning-mode all'
}
