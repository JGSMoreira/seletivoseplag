FROM eclipse-temurin:22-jdk

WORKDIR /seletivoSeplag

COPY . .

RUN chmod +x ./gradlew

CMD ["./gradlew", "clean", "bootRun"]
