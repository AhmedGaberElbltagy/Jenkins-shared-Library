#!/usr/bin/env groovy


def call( String imageName , String version ){
    echo " building the image ..."
     sh " docker build -t  $imageName:$version . "
}


