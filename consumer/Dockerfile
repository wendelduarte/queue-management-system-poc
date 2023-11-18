FROM maven:3-openjdk-17 AS build
COPY src /home/consumer/src
COPY pom.xml /home/consumer
RUN mvn -f /home/consumer/pom.xml clean package -DskipTests

FROM openjdk:17-alpine
COPY --from=build /home/consumer/target/*.jar /usr/local/lib/consumer/*.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/consumer/*.jar"]