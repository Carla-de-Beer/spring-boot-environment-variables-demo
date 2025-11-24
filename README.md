## Spring Boot Environment Variables Demo

This is a simple demo project to illustrate how environment variables are used and consumed within a Spring Boot project, with reference to the container within
which it runs.

The relevant Spring Documentation can be
found [here](https://docs.spring.io/spring-boot/reference/features/external-config.html#features.external-config.typesafe-configuration-properties.relaxed-binding.environment-variables).

### Steps to execute the application:

1. Repackage the project with the enclosed Maven wrapper:

```sh
bash mvnw clean package spring-boot:repackage -DskipTests
```

2. Build the Docker image:

```sh
docker build -f docker/Dockerfile -t carla-demo-app .
```

3. Run the Docker container:

```sh
docker container run --rm \
  -p 8080:8080 \
  -e XYZ_CONFIG_FEATUREFLAGS_RTME1470MULTIEDIT=CARLA \
  -e XYZ_CONFIG_FEATUREFLAGS_RTME2618ABGAENGE=CARLA \
  carla-demo-app
```

4. Call the API:

```sh
curl -X GET http://localhost:8080/api/demo/display-feature-flags
```

5. The environment variables can be viewed with this call:

```sh
curl -X GET http://localhost:8080/actuator/env | jq
```
