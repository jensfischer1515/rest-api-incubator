# REST API Incubator

Project to try out different REST API concerns.

## Build & run

## Locally
Use Gradle to run the project:
```bash
$ ./gradlew bootJar
```

## With a reverse proxy in front
Use docker-compose to run the project:
```bash
$ ./gredlew bootBuildImage
$ docker-compose up
```

## Covered concerns

### Content Negotiation

Different REST API endpoints are implemented via [GetController.kt](./src/main/kotlin/de/otto/rest/GetController.kt)
and [PostController.kt](./src/main/kotlin/de/otto/rest/PostController.kt).
They use an incoming `Accept` request header to perform content negotiation.
Vendor-specific media types as well as standard media types with additional media type attributes for profile and version are available.
A suite of tests demonstrate, which type of headers can be successfully used for content negotiation, 
and which type of headers fail to do so.
