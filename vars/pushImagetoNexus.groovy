#!/usr/bin/env groovy

def call(String imageName){
    withCredentials([usernamePassword(credentialsId: 'Nexus_Credientials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "echo $PASS | docker login -u $USER --password-stdin 192.168.206.129:8083"
        sh "docker tag $imageName:1.1 192.168.206.129:8081/repository/$imageName"
        sh "docker push 192.168.206.129:8083/repository/$imageName:1.1"
    }
}

