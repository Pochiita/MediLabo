FROM alpine:3.20

ARG version=21.0.4.7.1

RUN apk --no-cache --update add openjdk21


RUN java -version

WORKDIR /app

COPY target/front-0.0.1-SNAPSHOT.jar /app/medilab-front-service.jar

EXPOSE 8091

ENTRYPOINT ["java", "-jar", "/app/medilab-front-service.jar"]

