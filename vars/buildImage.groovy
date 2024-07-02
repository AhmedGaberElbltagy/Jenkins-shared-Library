#!/usr/bin/env groovy

import src/com.example.Docker

def call( String imageName ){

    return new Docker(this).buildDockerImag(imageName)
}



