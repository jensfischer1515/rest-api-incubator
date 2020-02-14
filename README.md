# REST API Incubator

Project to try out different REST API concerns.

## Build & run

Use Gradle to build the project and run its tests:

```bash
$ ./gradlew build
```

## Covered concerns

### Content Negotiation

Different REST API endpoints are implemented via [GetController.kt](./src/main/kotlin/de/otto/rest/GetController.kt)
and [PostController.kt](./src/main/kotlin/de/otto/rest/PostController.kt).
They use an incoming `Accept` request header to perform content negotiation.
Vendor-specific media types as well as standard media types with additional media type attributes for profile and version are available.
A suite of tests demonstrate, which type of headers can be successfully used for content negotiation, 
and which type of headers fail to do so.
