# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine

RUN apk add --no-cache bash

# copy WAR into image
COPY target/authws-0.0.1-SNAPSHOT.war /app.war 

#Copy logging setup
COPY target/classes/logback.xml /logback.xml

COPY run.sh /run.sh

# run application with this command line 
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default","-Dlogging.config=/logback.xml", "/app.war"]


#ENTRYPOINT ["/run.sh"]