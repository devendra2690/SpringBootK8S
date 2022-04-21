FROM adoptopenjdk/openjdk11:alpine-jre as builder
# First stage : Extract the layers
WORKDIR ordermanagement
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ordermanagement.jar
RUN java -Djarmode=layertools -jar ordermanagement.jar extract

FROM adoptopenjdk/openjdk11:alpine-jre as runtime
# Second stage : Copy the extracted layers
COPY --from=builder ordermanagement/dependencies/ ./
COPY --from=builder ordermanagement/spring-boot-loader ./
COPY --from=builder ordermanagement/snapshot-dependencies/ ./
COPY --from=builder ordermanagement/application/ ./
CMD ["java", "org.springframework.boot.loader.JarLauncher"]