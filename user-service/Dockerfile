FROM maven:3.8.7-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -B -DskipTests package

FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/user-service.jar ./user-service.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app/user-service.jar"]
