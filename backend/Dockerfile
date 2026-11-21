# Etapa 1: build com o Maven Wrapper
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY .mvn .mvn
COPY mvnw pom.xml ./
# No Windows o git pode não guardar o bit de execução do mvnw
RUN chmod +x mvnw && ./mvnw -q -B dependency:go-offline
COPY src src
RUN ./mvnw -q -B package -DskipTests

# Etapa 2: imagem final só com o JRE
FROM eclipse-temurin:21-jre
WORKDIR /app
RUN useradd --system --uid 1001 guide
COPY --from=build /app/target/guide-api-*.jar app.jar
USER guide
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
