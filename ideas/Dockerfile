# Base Apline Linux image with OpenJDK JRE only
FROM openjdk:8-jre-alpine
MAINTAINER MatthewD mbd06b@gmail.com
ENV APP_FILE ideas-0.0.1-SNAPSHOT.jar
ENV APP_HOME /app
EXPOSE 8172
COPY target/$APP_FILE $APP_HOME/
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE"]