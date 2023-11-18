FROM maven:3-openjdk-17 AS build
COPY src /home/provider/src
COPY pom.xml /home/provider
RUN mvn -f /home/provider/pom.xml clean package -DskipTests

FROM openjdk:17-alpine
COPY --from=build /home/provider/target/*.jar /usr/local/lib/provider/*.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/provider/*.jar"]