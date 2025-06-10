# Gunakan base image dengan JDK 24
FROM openjdk:24-ea-jdk-slim

# Set working directory di dalam container
WORKDIR /app

# Copy file JAR hasil build ke dalam image
COPY target/sales-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 (ubah jika port aplikasimu beda)
EXPOSE 8080

# Jalankan aplikasi
ENTRYPOINT ["java", "-jar", "app.jar"]