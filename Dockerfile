# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="techmonks@gmail.com"

# Add a volume pointing to /user-service
VOLUME /user-service

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=build/libs/user-service-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} userservice.jar

# Run the jar file 
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","-Dspring.profiles.active=default", "/userservice.jar"]
ENTRYPOINT ["java","-javaagent:/opt/elastic-apm-agent-1.11.0.jar","-Delastic.apm.service_name=user-service-docker","-Delastic.apm.server_url=http://13.233.198.21:8200","-Delastic.apm.application_packages=com.ts","-Djava.security.egd=file:/dev/./urandom","-jar","-Dspring.profiles.active=default", "/userservice.jar"]
