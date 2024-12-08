FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /jora-loger

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -X -DskipTests

FROM openjdk:17-jdk-alpine
COPY --from=build /jora-loger/target/*.jar jora-loger.jar
ENTRYPOINT ["java","-jar","jora-loger.jar"]