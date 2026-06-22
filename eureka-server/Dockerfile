FROM maven:3.8.7-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -B -DskipTests package

FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/eureka-server.jar ./eureka-server.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","/app/eureka-server.jar"]
