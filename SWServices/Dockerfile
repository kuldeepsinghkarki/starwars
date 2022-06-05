FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} SWServices-1.0-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/SWServices-1.0-SNAPSHOT.jar"]