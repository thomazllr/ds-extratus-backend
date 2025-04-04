FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

EXPOSE 8080
# Ajuste o nome para corresponder ao seu arquivo JAR real
CMD ["java", "-jar", "target/ds-extratus-0.0.1-SNAPSHOT.jar"]