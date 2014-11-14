#!/bin/bash

echo "You may need to manually install the 'maven' build tool"

git clone git@github.com:OfficeDev/ews-java-api.git
cd ews-java-api
mvn clean install

echo "Installing Play framework"

wget http://downloads.typesafe.com/typesafe-activator/1.2.10/typesafe-activator-1.2.10-minimal.zip
unzip ./typesafe-activator-1.2.10-minimal.zip

echo "Don't forget to add these"
echo "export PATH=./activator-1.2.10-minimal:\$PATH"
echo "export CLASSPATH=./activator-1.2.10-minimal:\$CLASSPATH"

