FROM adoptopenjdk/openjdk11:alpine-jre as builder
# First stage : Extract the layers
WORKDIR notificationmanager
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} notificationmanager.jar
RUN java -Djarmode=layertools -jar notificationmanager.jar extract

FROM adoptopenjdk/openjdk11:alpine-jre as runtime
# Second stage : Copy the extracted layers
COPY --from=builder notificationmanager/dependencies/ ./
COPY --from=builder notificationmanager/spring-boot-loader ./
COPY --from=builder notificationmanager/snapshot-dependencies/ ./
COPY --from=builder notificationmanager/application/ ./
CMD ["java", "org.springframework.boot.loader.JarLauncher"]