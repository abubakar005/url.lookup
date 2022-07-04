# url.lookup

# Steps to run the Project

Pre-requisites
1. Java 14
2. Docker (Optional if you want to run based on Docker container)
3. Tool to open the project like Intellij, Eclipse , etc

Run application
1. Open the project in any tool like IntelliJ and configure java 14
2. Run the application directly using the tool
3. Or Run the application using the Docker image as per the instructions below

# Tech Stack

1. Spring Boot with Java 14 (Rest APIs)
2. Open API - Swagger (API Documentation)
3. Github (Code Management)
4. Docker (Containerization)
5. Github Actions (Automatic Deployment using Pipeline)
6. Heroku (Cloud) - (Application available after auto deployment)
7. Actuator (Health Check)
8. Unit Test


# Information of deployment on Docker container

Docker file for this project is available at the root directory

Commands are below to build and run the docker image (from the directory where docker file is placed)

	1) Build the project JAR file (mvn clean install) 
	2) docker build --tag=url.lookup:latest .
	3) docker run -d --name url_lookup_container -p8081:8080 url.lookup:latest 

	Note: 
		1) External port (8081) can be changed according to the requirement, it could be any
		

# Heroku Deployment

I have also added configurations for auto deployment on **Heroku cloud** using the **Github actions** pipeline. Every time project will be auto deploy on every commit in the main branch

- Actuator Health API: https://ab-url-lookup.herokuapp.com/actuator/health
- Swagger URL on Heroku Cloud: https://ab-url-lookup.herokuapp.com/swagger-ui/index.html


**NOTE:** Application is deployed on Heroku cloud, APIs are accessible.

**NOTE:** I have not used any Database as mentioned in the document instead I have used MAP for URLs mapping. Initially, I'm inserting some values in the MAps available in the document for testing.
I have also implemented an endpoint (Rest API) for insertion any new URLs mapping. It will add new mapping bi-directionally like in the two MAPs.
I am using two MAPs here for achieving bi-directional mapping as there is no default implementation for this. I found there are few third party libraries like Apache and Guava which provides bi-directional MAP but internally they also use two MAPs to achieve this.
