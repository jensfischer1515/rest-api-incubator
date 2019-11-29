package de.otto.rest

import org.springframework.http.HttpHeaders.ACCEPT
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/accept")
class AcceptController {

    @GetMapping
    fun none(@RequestHeader(name = ACCEPT, required = false) accept: String?): BodyHAL = ResponseEntity.ok(Body(accept))

    @GetMapping(produces = ["application/json"])
    fun applicationJson(@RequestHeader(name = ACCEPT, required = false) accept: String?): BodyHAL = ResponseEntity.ok(Body(accept))

    @GetMapping(produces = ["application/json;charset=UTF-8"])
    fun applicationJsonUtf8(@RequestHeader(name = ACCEPT, required = false) accept: String?): BodyHAL = ResponseEntity.ok(Body(accept))

    @GetMapping(produces = ["application/hal+json"])
    fun applicationHalJson(@RequestHeader(name = ACCEPT, required = false) accept: String?): BodyHAL = ResponseEntity.ok(Body(accept))

    @GetMapping(produces = ["application/hal+json;charset=UTF-8"])
    fun applicationHalJsonUtf8(@RequestHeader(name = ACCEPT, required = false) accept: String?): BodyHAL = ResponseEntity.ok(Body(accept))

    @GetMapping(produces = ["""application/hal+json;profile="https://api.otto.de/api-docs/profiles/incubator""""])
    fun applicationHalJsonProfile(@RequestHeader(name = ACCEPT, required = false) accept: String?): BodyHAL = ResponseEntity.ok(Body(accept))

    @GetMapping(produces = ["""application/hal+json;profile="https://api.otto.de/api-docs/profiles/incubator";version=1.0"""])
    fun applicationHalJsonProfileVersion1(@RequestHeader(name = ACCEPT, required = false) accept: String?): BodyHAL = ResponseEntity.ok(Body(accept))

    @GetMapping(produces = ["""application/hal+json;profile="https://api.otto.de/api-docs/profiles/incubator";version=2.0"""])
    fun applicationHalJsonProfileVersion2(@RequestHeader(name = ACCEPT, required = false) accept: String?): BodyHAL = ResponseEntity.ok(Body(accept))

    @GetMapping(produces = ["application/vnd.otto"])
    fun applicationVendorOtto(@RequestHeader(name = ACCEPT, required = false) accept: String?): BodyHAL = ResponseEntity.ok(Body(accept))

    @GetMapping(produces = ["application/vnd.otto+json"])
    fun applicationVendorOttoJson(@RequestHeader(name = ACCEPT, required = false) accept: String?): BodyHAL = ResponseEntity.ok(Body(accept))

    @GetMapping(produces = ["application/vnd.otto.incubator.v1+json"])
    fun applicationVendorOttoIncubatorV1Json(@RequestHeader(name = ACCEPT, required = false) accept: String?): BodyHAL = ResponseEntity.ok(Body(accept))

    @GetMapping(produces = ["application/vnd.otto.incubator.v2+json"])
    fun applicationVendorOttoIncubatorV2Json(@RequestHeader(name = ACCEPT, required = false) accept: String?): BodyHAL = ResponseEntity.ok(Body(accept))
}

typealias BodyHAL = ResponseEntity<Body>

data class Body(val accept: String?)
