package de.otto.rest

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/json-profiles")
class JsonProfileController {
    @GetMapping(produces = ["application/json"])
    fun applicationJson() = ResponseEntity.ok(ResponsePayload(accept = "json, no profile"))

    @GetMapping(produces = ["""application/json;profile="https://api.otto.de/api-docs/profiles/response""""])
    fun applicationJsonResponse() = ResponseEntity.ok(ResponsePayload(accept = "json, profile-v1"))

    @GetMapping(produces = ["""application/json;profile="https://api.otto.de/api-docs/profiles/response-v2""""])
    fun applicationJsonResponseV2() = ResponseEntity.ok(ResponsePayload(accept = "json, profile-v2"))

    @PostMapping(
        consumes = ["""application/json;profile="https://api.otto.de/api-docs/profiles/response""""],
        produces = ["""application/hal+json;profile="https://api.otto.de/api-docs/profiles/response""""]
    )
    fun postVersion1(@RequestBody request : String) = ResponseEntity.ok(ResponsePayload(accept = "version-1"))

    @PostMapping(
        consumes = ["""application/json;profile="https://api.otto.de/api-docs/profiles/response-v2""""],
        produces = ["""application/hal+json;profile="https://api.otto.de/api-docs/profiles/response-v2""""]
    )
    fun postVersion2(@RequestBody request : String) = ResponseEntity.ok(ResponsePayload(accept = "version-2"))
}