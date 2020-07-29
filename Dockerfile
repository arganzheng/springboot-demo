FROM openjdk:8-jdk-alpine 
COPY target/springboot-demo-0.0.1-SNAPSHOT.jar /apps/app.jar
EXPOSE 8080  
ENTRYPOINT ["java", "-jar", "/app.jar"] 