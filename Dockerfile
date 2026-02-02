# Use lightweight Java runtime
FROM eclipse-temurin:17-jre

# Set working directory
WORKDIR /app

# Copy jar from Maven build
COPY target/*.jar app.jar

# Expose app port (change if your app uses different port)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
