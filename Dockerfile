FROM eclipse-temurin:17-alpine

RUN mkdir /opt/app
COPY ./build/libs/*.jar /opt/app/app.jar

ARG ARG_PROFILE
ENV PROFILE=${ARG_PROFILE}

CMD ["java", "-Dspring.profiles.active=${PROFILE}", "-jar", "/opt/app/app.jar"]