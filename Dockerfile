## Use the GraalVM image for Java 21 and native-image tool
#FROM ghcr.io/graalvm/graalvm-community:21.0.2-ol9-20240116
#
## Install dependencies like JDK, native-image, and any other libraries
##RUN gu install native-image
#
## Set up the working directory in the container
#WORKDIR /app
#
## Copy the JAR file into the container
#COPY build/libs/springgraalvm-0.0.1-SNAPSHOT.jar /app/
#
## Build the native image for Linux
#RUN native-image --no-fallback -cp springgraalvm-0.0.1-SNAPSHOT.jar -H:Class=com.example.demo.SpringgraalvmApplication
#
## The resulting executable will be named your-app
#CMD ["./springgraalvm-0.0.1-SNAPSHOT"]
