#!/usr/bin/env groovy


def call(){
    echo " building the image ..."
     sh 'docker build -t java-maven-app .'
}