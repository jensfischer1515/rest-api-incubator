package de.otto.rest

import org.springframework.http.HttpHeaders.ACCEPT
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/incubator")
class GetController {

    @GetMapping
    fun none(
            @RequestHeader(name = ACCEPT, required = false) accept: String?
    ): ResponseHal = ResponseEntity.ok(ResponsePayload(accept = accept))

    @GetMapping(produces = ["application/json"])
    fun applicationJson(
            @RequestHeader(name = ACCEPT, required = false) accept: String?
    ): ResponseHal = ResponseEntity.ok(ResponsePayload(accept = accept))

    @GetMapping(produces = ["application/json;charset=UTF-8"])
    fun applicationJsonUtf8(
            @RequestHeader(name = ACCEPT, required = false) accept: String?
    ): ResponseHal = ResponseEntity.ok(ResponsePayload(accept = accept))

    @GetMapping(produces = ["application/hal+json"])
    fun applicationHalJson(
            @RequestHeader(name = ACCEPT, required = false) accept: String?
    ): ResponseHal = ResponseEntity.ok(ResponsePayload(accept = accept))

    @GetMapping(produces = ["application/hal+json;charset=UTF-8"])
    fun applicationHalJsonUtf8(
            @RequestHeader(name = ACCEPT, required = false) accept: String?
    ): ResponseHal = ResponseEntity.ok(ResponsePayload(accept = accept))

    @GetMapping(produces = ["""application/hal+json;profile="https://api.otto.de/api-docs/profiles/response""""])
    fun applicationHalJsonResponse(
            @RequestHeader(name = ACCEPT, required = false) accept: String?
    ): ResponseHal = ResponseEntity.ok(ResponsePayload(accept = accept))

    @GetMapping(produces = ["""application/hal+json;profile="https://api.otto.de/api-docs/profiles/response";version=1.0"""])
    fun applicationHalJsonResponseVersion1(
            @RequestHeader(name = ACCEPT, required = false) accept: String?
    ): ResponseHal = ResponseEntity.ok(ResponsePayload(accept = accept))

    @GetMapping(produces = ["""application/hal+json;profile="https://api.otto.de/api-docs/profiles/response";version=2.0"""])
    fun applicationHalJsonResponseVersion2(
            @RequestHeader(name = ACCEPT, required = false) accept: String?
    ): ResponseHal = ResponseEntity.ok(ResponsePayload(accept = accept))

    @GetMapping(produces = ["application/vnd.otto"])
    fun applicationVendorOtto(@RequestHeader(name = ACCEPT, required = false) accept: String?): ResponseHal =
            ResponseEntity.ok(ResponsePayload(accept = accept))

    @GetMapping(produces = ["application/vnd.otto+json"])
    fun applicationVendorOttoJson(
            @RequestHeader(name = ACCEPT, required = false) accept: String?
    ): ResponseHal = ResponseEntity.ok(ResponsePayload(accept = accept))

    @GetMapping(produces = ["application/vnd.otto.response.v1+json"])
    fun applicationVendorOttoResponseV1Json(
            @RequestHeader(name = ACCEPT, required = false) accept: String?
    ): ResponseHal = ResponseEntity.ok(ResponsePayload(accept = accept))

    @GetMapping(produces = ["application/vnd.otto.response.v2+json"])
    fun applicationVendorOttoResponseV2Json(
            @RequestHeader(name = ACCEPT, required = false) accept: String?
    ): ResponseHal = ResponseEntity.ok(ResponsePayload(accept = accept))
}
