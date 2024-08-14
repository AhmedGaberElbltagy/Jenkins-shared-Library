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
    def dockerLogin () {
        withCredentials([usernamePassword(credentialsId: 'DockerHub_Credientials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
        }
    }
    def dockerPush (String imageName) {
        script.echo "pushing the image to Docker......"
        script.sh "docker tag $imageName ahmedelbltagy/$imageName"
        script.sh "docker push ahmedelbltagy/$imageName"
    } 
}
