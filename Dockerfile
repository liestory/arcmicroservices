FROM library/postgres

ENV POSTGRES_USER arcmicroservices
ENV POSTGRES_PASSWORD arcmicroservices
ENV POSTGRES_DB postgres

#-----------------------------------------
FROM gradle:jdk-alpine AS build

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build -x test
#-----------------------------------------

FROM eclipse-temurin:17-jdk-alpine

CMD ["java", "-jar", "microservice.jar", "application.yml"]
EXPOSE 8000

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/microservice.jar

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseContainerSupport", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/microservice.jar"]