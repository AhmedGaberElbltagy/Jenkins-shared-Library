#!/usr/bin/env groovy

def call(){
    echo " Linting the application ...."
    sh './gradlew checkstyleMain checkstyleTest --warning-mode all'
}
