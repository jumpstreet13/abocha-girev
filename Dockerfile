# Этап сборки (builder stage)
FROM gradle:jdk17 AS builder

# Рабочая директория
WORKDIR /app

# Копируем файлы gradle
COPY gradle gradle
COPY gradlew .
COPY settings.gradle.kts .
COPY build.gradle.kts .

# Подготовка зависимостей
RUN ./gradlew dependencies

# Копируем исходники
COPY src src

# Собираем приложение (создаем fat jar)
RUN ./gradlew jar

# Этап запуска (runtime stage)
FROM eclipse-temurin:17-jre-jammy

# Рабочая директория
WORKDIR /app

# Копируем fat jar из этапа сборки
COPY --from=builder /app/build/libs/*.jar app.jar

# Открываем порт, на котором работает Ktor
EXPOSE 8080

# Команда для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]