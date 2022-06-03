FROM openjdk:11

WORKDIR usr/src

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} UserService-0.0.1-SNAPSHOT

# ENV MONGO_URL=mongodb://localhost:27017/backofficespirits
# ENV MONGO_DATABASE=backofficespirits

ENTRYPOINT ["java","-jar","UserService-0.0.1-SNAPSHOT"]