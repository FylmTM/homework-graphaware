# we will use openjdk 8 with alpine as it is a very small linux distro
FROM openjdk:8-jre-alpine3.9

# copy the packaged jar file into our docker image
COPY target/pizzeria-0.0.1-SNAPSHOT.jar /pizzeria.jar

# set the startup command to execute the jar
CMD ["java", "-jar", "/pizzeria.jar"]

# build: docker build -t assessment/pizzeria:1.0-SNAPSHOT .