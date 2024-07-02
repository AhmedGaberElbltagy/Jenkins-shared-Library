#!/usr/bin/env groovy

def call(String imageName, String Version){
    withCredentials([usernamePassword(credentialsId: 'Nexus_Credientials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "echo $PASS | docker login -u $USER --password-stdin 192.168.206.129:8083"
        sh "docker tag $imageName 192.168.206.129:8081/repository/$imageName:$Version"
        sh "docker push 192.168.206.129:8083/repository/$imageName:$Version"
    }
}

#java-maven-app