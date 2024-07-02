#!/usr/bin/env groovy

package com.example

class Docker implements Serializable {
    def script
    
    Docker(script){
        this.script = script 
    }
    
    def buildDockerImage (String imageName) {
        script.echo "building the image ......"
        script.sh "docker build -t $imageName ."
    }
    def dockerLogin (String imageName) {
        script.withCredentials([usernamePassword(credentialsId: 'Nexus_Credientials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "echo script.$PASS | docker login -u script.$USER --password-stdin 192.168.206.129:8083"
        }
    }
    def dockerPush (String imageName) {
        script.sh "docker tag $imageName 192.168.206.129:8081/repository/$imageName"
        script.sh "docker push 192.168.206.129:8083/repository/$imageName"
    } 
}
