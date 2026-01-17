# Build stage
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
# Copy the backend source code
COPY backend /app/backend
# Build the application
WORKDIR /app/backend
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jre
WORKDIR /app
# Copy the built jar from build stage
COPY --from=build /app/backend/target/*.jar app.jar
# Expose the port (Render uses $PORT)
EXPOSE 8081
# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
