FROM maven:3.8.7 as build

#COPY . .
#RUN mvn -B clean Package - DskipTests

# Copy Maven files for dependency resolution
COPY pom.xml ./
COPY .mvn .mvn

# Copy application source code
COPY src src

# Build the project and create the executable JAR
RUN mvn package
FROM openjdk:17-jdk-slim
COPY --from=build ./target/*.jar blog.jar
EXPOSE 8080
ENTRYPOINT ["Java","-jar","blog.jar"]

