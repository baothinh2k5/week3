# --- Stage 1: Build WAR with Maven (JDK 17) ---
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml trước để cache dependency
COPY pom.xml .
RUN mvn -q -DskipTests dependency:go-offline

# Copy source và build
COPY src ./src
RUN mvn -q -DskipTests package

# --- Stage 2: Run on Tomcat 10 (Jakarta) ---
FROM tomcat:10.1-jdk17-temurin

# Xoá webapp mặc định (chúng ta sẽ thay thế với ROOT.war)
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy WAR từ Build Stage vào thư mục webapps của Tomcat
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# Mở port 8080 để Tomcat có thể nghe
EXPOSE 8080

# Chạy Tomcat
CMD ["catalina.sh", "run"]
