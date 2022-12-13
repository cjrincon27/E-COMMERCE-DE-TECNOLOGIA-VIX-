FROM gradle:jdk11-alpine
COPY . .
RUN gradle build
EXPOSE 8090
ENTRYPOINT ["java","-jar","build/libs/demo-0.0.1-SNAPSHOT.jar"]
