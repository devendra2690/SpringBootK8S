FROM adoptopenjdk/openjdk11:alpine-jre as builder
# First stage : Extract the layers
WORKDIR customermanagement
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} customermanagement.jar
RUN java -Djarmode=layertools -jar customermanagement.jar extract

FROM adoptopenjdk/openjdk11:alpine-jre as runtime
# Second stage : Copy the extracted layers
COPY --from=builder customermanagement/dependencies/ ./
COPY --from=builder customermanagement/spring-boot-loader ./
COPY --from=builder customermanagement/snapshot-dependencies/ ./
COPY --from=builder customermanagement/application/ ./
CMD ["java", "org.springframework.boot.loader.JarLauncher"]