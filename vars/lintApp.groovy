#!/usr/bin/env groovy

def call(){
    echo " testing the application ...."
    sh './gradlew checkstyleMain checkstyleTest --warning-mode all'
}
