FROM adoptopenjdk/openjdk11:alpine-jre as builder
# First stage : Extract the layers
WORKDIR notificationmanagerawssqs
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} notificationmanagerawssqs.jar
RUN java -Djarmode=layertools -jar notificationmanagerawssqs.jar extract

FROM adoptopenjdk/openjdk11:alpine-jre as runtime
# Second stage : Copy the extracted layers
COPY --from=builder notificationmanagerawssqs/dependencies/ ./
COPY --from=builder notificationmanagerawssqs/spring-boot-loader ./
COPY --from=builder notificationmanagerawssqs/snapshot-dependencies/ ./
COPY --from=builder notificationmanagerawssqs/application/ ./
CMD ["java", "org.springframework.boot.loader.JarLauncher"]
