FROM gradle:jdk17-alpine AS BUILD

WORKDIR /app

COPY build.gradle .

COPY settings.gradle .

COPY src ./src

RUN gradle build --no-daemon

FROM amazoncorretto:17-alpine

WORKDIR /app

COPY --from=BUILD /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]