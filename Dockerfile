FROM openjdk:17-jdk-slim
WORKDIR /app
COPY driver_charging_session_authenticator-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
