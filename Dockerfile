FROM openjdk:8
EXPOSE 8080
ADD target/Springwebappdemo.jar Springwebappdemo.jar
ENTRYPOINT ["java","-jar","/Springwebappdemo.jar"]
