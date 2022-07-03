FROM openjdk:14
MAINTAINER Abubakar

# Refer to Maven build
ARG JAR_FILE=target/url.lookup-0.0.1-SNAPSHOT.jar

# set working directory
WORKDIR /opt/app

# copy jar file to the deirectory /opt/app/
COPY ${JAR_FILE} url-lookup.jar

# Run project container
ENTRYPOINT ["java","-jar","url-lookup.jar"]