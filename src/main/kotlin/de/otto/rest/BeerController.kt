package de.otto.rest

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/beer")
class BeerController {

    @GetMapping(produces = ["application/hal+json;charset=UTF-8"])
    fun bothPay(): ResponseEntity<BeerPayload> = ResponseEntity.ok(BeerPayload(beer = "Beide zahlen"))

    @GetMapping(produces = ["""application/hal+json;profile="https://api.otto.de/api-docs/profiles/beer-jens""""])
    fun jensPays(): ResponseEntity<BeerPayload> = ResponseEntity.ok(BeerPayload(beer = "Jens zahlt"))

    @GetMapping(produces = ["""application/hal+json;profile="https://api.otto.de/api-docs/profiles/beer-guido""""])
    fun guidoPays(): ResponseEntity<BeerPayload> = ResponseEntity.ok(BeerPayload(beer = "Guido zahlt"))
}

data class BeerPayload(val beer: String)
