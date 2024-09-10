# Usa una imagen base con Maven para construir el proyecto
FROM maven:3.8.6-openjdk-17 AS build

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo pom.xml y descarga las dependencias
COPY API/pom.xml .

# Descarga las dependencias
RUN mvn dependency:go-offline

# Copia el código fuente
COPY API/src ./src

# Construye el proyecto y crea el archivo JAR
RUN mvn clean package -DskipTests

# Usa una imagen base con OpenJDK para ejecutar el proyecto
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR desde la etapa de construcción
COPY --from=build /app/target/inscripciones-0.0.1-SNAPSHOT.jar ./inscripciones.jar

# Expone el puerto en el que la aplicación estará escuchando
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "inscripciones.jar"]
