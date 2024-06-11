FROM maven:3.8.7 as build

COPY . .
RUN mvn -B clean Package - DskipTests
FROM openjdk:17
COPY --from=build ./target/*.jar blog.jar
EXPOSE 8080
ENTRYPOINT ["Java","-jar","blog.jar"]

