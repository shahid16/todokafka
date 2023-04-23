FROM openjdk:17-jdk-slim
VOLUME /tmp
EXPOSE 8081
ADD build/libs/todo-0.0.1-SNAPSHOT.jar spring-boot-docker.jar
ENTRYPOINT ["java","-jar","/spring-boot-docker.jar"]