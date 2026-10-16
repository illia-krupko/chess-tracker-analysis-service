FROM eclipse-temurin:21-jdk-noble AS builder

WORKDIR /app

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY checkstyle.xml .

RUN chmod +x gradlew
RUN ./gradlew dependencies --no-daemon


FROM eclipse-temurin:21-jre-noble

RUN apt-get update \
    && apt-get install -y --no-install-recommends stockfish \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

ENV STOCKFISH_PATH=/usr/games/stockfish

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
