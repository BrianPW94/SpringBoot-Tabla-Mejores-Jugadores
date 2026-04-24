# ---------- BUILD STAGE ----------
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# ---------- RUN STAGE ----------
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 10000

CMD ["java","-jar","app.jar"]
