#!/bin/sh
java -jar app.jar \
    --spring.profiles.active=${SPRING_PROFILES_ACTIVE:-prod} \
    --server.port=${PORT:-8080} \
    --spring.datasource.url=${DATABASE_URL:-jdbc:h2:mem:spaceshipdb} \
    --spring.datasource.username=${DATABASE_USERNAME:-sa} \
    --spring.datasource.password=${DATABASE_PASSWORD:-} \
    --app.jwt.secret=${JWT_SECRET:-default_secret_key} \
    --app.jwt.expiration=${JWT_EXPIRATION:-86400000}