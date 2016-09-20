#!/bin/bash

echo "Shutdown tomcat"
/opt/tomcat8/bin/shutdown.sh

echo "Build war"
./gradlew clean war

echo "Clear tomcat application"
rm -rf /opt/tomcat8/webapps/javault-mvc-0.0.1*

echo "Copy war"
cp build/libs/javault-mvc-0.0.1.war /opt/tomcat8/webapps/

echo "Start tomcat"
/opt/tomcat8/bin/startup.sh -security
