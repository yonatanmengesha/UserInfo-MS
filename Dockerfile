FROM adoptopenjdk/openjdk11:jdk-11.0.2.9-slim
WORKDIR /opt
COPY target/*.jar  /opt/app.jar
ENTRYPOINT exec java $JAVA-OPTS  -jar app.jar