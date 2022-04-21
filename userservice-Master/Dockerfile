FROM openjdk:8
EXPOSE 3005
ADD target/user-service.jar user-service.jar
ENTRYPOINT ["java","-jar","user-service.jar"]