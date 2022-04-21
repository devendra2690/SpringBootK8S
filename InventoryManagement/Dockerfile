FROM adoptopenjdk/openjdk11:alpine-jre as builder
# First stage : Extract the layers
WORKDIR inventorymanagement
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} inventorymanagement.jar
RUN java -Djarmode=layertools -jar inventorymanagement.jar extract

FROM adoptopenjdk/openjdk11:alpine-jre as runtime
# Second stage : Copy the extracted layers
COPY --from=builder inventorymanagement/dependencies/ ./
COPY --from=builder inventorymanagement/spring-boot-loader ./
COPY --from=builder inventorymanagement/snapshot-dependencies/ ./
COPY --from=builder inventorymanagement/application/ ./
CMD ["java", "org.springframework.boot.loader.JarLauncher"]