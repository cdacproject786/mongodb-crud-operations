FROM eclipse-temurin:17-alpine

LABEL mentainer="arbaazsayed1602@gmail.com"

WORKDIR /app

COPY target/mongodb-crud-operations-0.0.1-SNAPSHOT.jar /app/mongodb-crud-operations-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "mongodb-crud-operations-0.0.1-SNAPSHOT.jar"]