FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml first and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Now copy the rest of the code
COPY src ./src

# Build
RUN mvn clean package -DskipTests

# Final image
FROM openjdk:17-jdk
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]