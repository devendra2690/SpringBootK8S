FROM adoptopenjdk/openjdk11:alpine-jre as builder
# First stage : Extract the layers
WORKDIR ordernotificatopnawspubsub
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ordernotificatopnawspubsub.jar
RUN java -Djarmode=layertools -jar ordernotificatopnawspubsub.jar extract

FROM adoptopenjdk/openjdk11:alpine-jre as runtime
# Second stage : Copy the extracted layers
COPY --from=builder ordernotificatopnawspubsub/dependencies/ ./
COPY --from=builder ordernotificatopnawspubsub/spring-boot-loader ./
COPY --from=builder ordernotificatopnawspubsub/snapshot-dependencies/ ./
COPY --from=builder ordernotificatopnawspubsub/application/ ./
CMD ["java", "org.springframework.boot.loader.JarLauncher"]
