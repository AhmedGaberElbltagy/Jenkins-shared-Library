#!/usr/bin/env groovy

def call(){

    withCredentials([usernamePassword(credentialsId: 'Nexus_Credientials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "echo $PASS | docker login -u $USER --password-stdin 192.168.206.129:8083"
        sh 'docker tag java-maven-app 192.168.206.129:8081/repository/java-maven-app'
        sh 'docker push 192.168.206.129:8083/repository/java-maven-app'
    }
}