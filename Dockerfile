# syntax=docker/dockerfile:1

FROM openjdk:11

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN mvnw clean install

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]