FROM openjdk:17

WORKDIR /app

COPY ./target/milioner.jar .

CMD ["java", "-jar", "milioner.jar"]