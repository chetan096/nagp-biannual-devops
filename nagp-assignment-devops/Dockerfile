FROM azul/zulu-openjdk-alpine:11
MAINTAINER CHETAN MAHAJAN
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]