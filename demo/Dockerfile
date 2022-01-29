FROM openjdk:14
COPY ./target/demo-0.0.1-SNAPSHOT.jar /usr/src/demo/
WORKDIR /usr/src/demo
EXPOSE 8080
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]