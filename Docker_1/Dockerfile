# Etap 1: Budowanie aplikacji
FROM alpine:latest AS build
WORKDIR /app
RUN apk update && apk add --no-cache openjdk17 maven git
RUN git clone https://github.com/kosisnk/JenkinsDockerK8sDemo.git .
WORKDIR /app/TestApp
RUN mvn clean install

# Etap 2: Uruchamianie aplikacji
FROM alpine:latest
WORKDIR /app
RUN apk update && apk add --no-cache openjdk17-jre
COPY --from=build /app/TestApp/target/test_web_app-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-jar", "test_web_app-0.0.1-SNAPSHOT.jar"]

#docker build -t  testapp:X .
#docker run -d -p 8081:8080 testapp:2