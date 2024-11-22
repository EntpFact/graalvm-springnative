FROM openjdk:21-jdk-slim
ADD ./build/libs/springgraalvm-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
