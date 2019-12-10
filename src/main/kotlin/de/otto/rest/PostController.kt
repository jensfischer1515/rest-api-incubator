package de.otto.rest

import org.springframework.http.HttpHeaders.ACCEPT
import org.springframework.http.HttpHeaders.CONTENT_TYPE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/incubator", produces = ["""application/hal+json;profile="https://api.otto.de/api-docs/profiles/response";version=1.0"""])
class PostController {

    //@PostMapping
    fun none(
            @RequestHeader(name = ACCEPT, required = false) accept: String?,
            @RequestHeader(name = CONTENT_TYPE, required = false) contentType: String?,
            @RequestBody requestPayload: RequestPayload
    ): ResponseHal = ResponseEntity.ok(ResponsePayload(accept = accept, contenType = contentType, requestPayload = requestPayload))

    @PostMapping(consumes = ["application/json"])
    fun applicationJson(
            @RequestHeader(name = ACCEPT, required = false) accept: String?,
            @RequestHeader(name = CONTENT_TYPE, required = false) contentType: String?,
            @RequestBody requestPayload: RequestPayload
    ): ResponseHal = ResponseEntity.ok(ResponsePayload(accept = accept, contenType = contentType, requestPayload = requestPayload))

    @PostMapping(consumes = ["application/json;charset=UTF-8"])
    fun applicationJsonUtf8(
            @RequestHeader(name = ACCEPT, required = false) accept: String?,
            @RequestHeader(name = CONTENT_TYPE, required = false) contentType: String?,
            @RequestBody requestPayload: RequestPayload
    ): ResponseHal = ResponseEntity.ok(ResponsePayload(accept = accept, contenType = contentType, requestPayload = requestPayload))

    @PostMapping(consumes = ["application/hal+json"])
    fun applicationHalJson(
            @RequestHeader(name = ACCEPT, required = false) accept: String?,
            @RequestHeader(name = CONTENT_TYPE, required = false) contentType: String?,
            @RequestBody requestPayload: RequestPayload
    ): ResponseHal = ResponseEntity.ok(ResponsePayload(accept = accept, contenType = contentType, requestPayload = requestPayload))

    @PostMapping(consumes = ["application/hal+json;charset=UTF-8"])
    fun applicationHalJsonUtf8(
            @RequestHeader(name = ACCEPT, required = false) accept: String?,
            @RequestHeader(name = CONTENT_TYPE, required = false) contentType: String?,
            @RequestBody requestPayload: RequestPayload
    ): ResponseHal = ResponseEntity.ok(ResponsePayload(accept = accept, contenType = contentType, requestPayload = requestPayload))

    @PostMapping(consumes = ["""application/json;charset=UTF-8;profile="https://api.otto.de/api-docs/profiles/request""""])
    fun applicationJsonRequest(
            @RequestHeader(name = ACCEPT, required = false) accept: String?,
            @RequestHeader(name = CONTENT_TYPE, required = false) contentType: String?,
            @RequestBody requestPayload: RequestPayload
    ): ResponseHal = ResponseEntity.ok(ResponsePayload(accept = accept, contenType = contentType, requestPayload = requestPayload))

    @PostMapping(consumes = ["""application/json;charset=UTF-8;profile="https://api.otto.de/api-docs/profiles/request";version=1.0"""])
    fun applicationJsonRequestVersion1(
            @RequestHeader(name = ACCEPT, required = false) accept: String?,
            @RequestHeader(name = CONTENT_TYPE, required = false) contentType: String?,
            @RequestBody requestPayload: RequestPayload
    ): ResponseHal = ResponseEntity.ok(ResponsePayload(accept = accept, contenType = contentType, requestPayload = requestPayload))
}
