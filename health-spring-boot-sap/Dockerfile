FROM java:8
VOLUME /tmp
ADD target/health-spring-boot-sap.war app.jar
RUN bash -c 'touch /app.jar'
ENV SPRING_PROFILES_ACTIVE docker
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
