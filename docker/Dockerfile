FROM eclipse-temurin:21-jre-alpine AS builder
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar

ARG PROFILE

ENV MLS_CONFIG_FEATURE_FLAGS_RTME_1470_MULTI_EDIT=FOO

RUN java -Djarmode=layertools -jar application.jar extract

FROM eclipse-temurin:21-jre-alpine

# CVE-2023-5363 workaround, until an updated Alpine image has been made available
RUN apk upgrade --update-cache --available && \
    apk add openssl && \
    rm -rf /var/cache/apk/* && \
    addgroup --system javauser && adduser -S -s /bin/false -G javauser javauser
USER javauser

COPY --from=builder --chown=javauser:javauser dependencies/ ./
COPY --from=builder --chown=javauser:javauser spring-boot-loader/ ./
COPY --from=builder --chown=javauser:javauser application/ ./

EXPOSE 8080

ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]