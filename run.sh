#!/bin/bash

MAVEN_REPO="/home/ptaylor/.m2/repository"

MYCLASSPATH="$MAVEN_REPO/com/microsoft/office/ews-java-api/1.3-SNAPSHOT/ews-java-api-1.3-SNAPSHOT.jar:$MYCLASSPATH"
MYCLASSPATH="$MAVEN_REPO/commons-httpclient/commons-httpclient/3.1/commons-httpclient-3.1.jar:$MYCLASSPATH"
MYCLASSPATH="$MAVEN_REPO/commons-logging/commons-logging/commons-logging-1.2.jar:$MYCLASSPATH"
MYCLASSPATH="$MAVEN_REPO/commons-logging/commons-logging-api/1.1/commons-logging-api-1.1.jar:$MYCLASSPATH"
MYCLASSPATH="$MAVEN_REPO/commons-codec/commons-codec/1.2/commons-codec-1.2.jar:$MYCLASSPATH"
MYCLASSPATH="$MAVEN_REPO/commons-codec/commons-codec/1.6/commons-codec-1.6.jar:$MYCLASSPATH"
MYCLASSPATH="$MAVEN_REPO/jcifs/jcifs/1.3.17/jcifs-1.3.17.jar:$MYCLASSPATH"

export CLASSPATH="$MYCLASSPATH:$CLASSPATH"

cd src
javac ExchangeGroupCalendar/CalendarQuery.java
javac Main.java

java Main $@
