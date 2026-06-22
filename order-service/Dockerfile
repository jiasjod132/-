FROM maven:3.8.7-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -B -DskipTests package

FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/order-service.jar ./order-service.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/app/order-service.jar"]
