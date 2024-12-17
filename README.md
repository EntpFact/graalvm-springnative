Steps to create native-image after successfully installing graalvm JDK21:

check versions of java and native-image:

C:\IntelliJ\HDFC\POC\springgraalvm>java --version
java 21.0.5 2024-10-15 LTS
Java(TM) SE Runtime Environment Oracle GraalVM 21.0.5+9.1 (build 21.0.5+9-LTS-jvmci-23.1-b48)
Java HotSpot(TM) 64-Bit Server VM Oracle GraalVM 21.0.5+9.1 (build 21.0.5+9-LTS-jvmci-23.1-b48, mixed mode, sharing)

C:\IntelliJ\HDFC\POC\springgraalvm>native-image --version
native-image 21.0.5 2024-10-15
GraalVM Runtime Environment Oracle GraalVM 21.0.5+9.1 (build 21.0.5+9-LTS-jvmci-23.1-b48)
Substrate VM Oracle GraalVM 21.0.5+9.1 (build 21.0.5+9-LTS, serial gc, compressed references)

commands:

gradlew clean build

gradlew bootBuildImage


after the above commands docker image will be created and run the application by following commands:


docker run -d -p 8080:8080 --name graalvm-app graalvm-docker-image-gradle:latest

dapr run --app-id graalvm-app --app-port 8080 --dapr-http-port 3500 --dapr-grpc-port 50001 --components-path ./components


service to service invocation
1) dapr app - invoke method
2) non dapr app - http binding - invoke binding
3) non dapr app - http endpoint - invoke method

kafka pub sub
3) pubsub - publish event
4) pubsub - invoke binding
