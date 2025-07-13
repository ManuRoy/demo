FROM openjdk:17-jdk-slim

WORKDIR /app

ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Copy your application.properties
COPY src/main/resources/application.properties /app/config/application.properties

ENTRYPOINT ["java", "-jar", "app.jar", "--spring.config.location=file:/app/config/application.properties"]
