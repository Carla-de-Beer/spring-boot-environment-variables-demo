FROM eclipse-temurin:21-jre-jammy AS builder
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar

RUN java -Djarmode=layertools -jar application.jar extract

FROM eclipse-temurin:21-jre-jammy

#ENV XYZ_CONFIG_FEATUREFLAGS_RTME1470MULTIEDIT=FOO

RUN groupadd --system javauser && \
    useradd --system --no-create-home --gid javauser --shell /usr/sbin/nologin javauser
USER javauser

COPY --from=builder --chown=javauser:javauser dependencies/ ./
COPY --from=builder --chown=javauser:javauser spring-boot-loader/ ./
COPY --from=builder --chown=javauser:javauser application/ ./

EXPOSE 8080

ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]