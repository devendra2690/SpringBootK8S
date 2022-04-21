FROM adoptopenjdk/openjdk11:alpine-jre as builder
# First stage : Extract the layers
WORKDIR inventorygateway
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} inventorygateway.jar
RUN java -Djarmode=layertools -jar inventorygateway.jar extract

FROM adoptopenjdk/openjdk11:alpine-jre as runtime
# Second stage : Copy the extracted layers
COPY --from=builder inventorygateway/dependencies/ ./
COPY --from=builder inventorygateway/spring-boot-loader ./
COPY --from=builder inventorygateway/snapshot-dependencies/ ./
COPY --from=builder inventorygateway/application/ ./
CMD ["java", "org.springframework.boot.loader.JarLauncher"]
