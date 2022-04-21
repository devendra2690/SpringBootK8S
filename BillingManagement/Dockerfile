FROM adoptopenjdk/openjdk11:alpine-jre as builder
# First stage : Extract the layers
WORKDIR billingmanagement
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} billingmanagement.jar
RUN java -Djarmode=layertools -jar billingmanagement.jar extract

FROM adoptopenjdk/openjdk11:alpine-jre as runtime
# Second stage : Copy the extracted layers
COPY --from=builder billingmanagement/dependencies/ ./
COPY --from=builder billingmanagement/spring-boot-loader ./
COPY --from=builder billingmanagement/snapshot-dependencies/ ./
COPY --from=builder billingmanagement/application/ ./
CMD ["java", "org.springframework.boot.loader.JarLauncher"]