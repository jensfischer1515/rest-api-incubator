package de.otto.rest

import org.springframework.http.ResponseEntity

data class ResponsePayload(
        val accept: String? = null,
        val contenType: String? = null,
        val requestPayload: RequestPayload? = null
)

typealias ResponseHal = ResponseEntity<ResponsePayload>
