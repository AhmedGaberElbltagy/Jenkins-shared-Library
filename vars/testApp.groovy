#!/usr/bin/env groovy

def call(){
    echo " testing the application ...."
    sh './gradlew test'
}
