FROM eclipse-temurin:17-alpine

COPY target/_9_1_HW_AutoConfiguration-0.0.1-SNAPSHOT.jar HW_9_1_app

EXPOSE 8081

CMD ["java", "-jar", "HW_9_1_app"]