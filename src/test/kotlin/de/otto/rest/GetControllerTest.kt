package de.otto.rest

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.log
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup
import org.springframework.web.context.WebApplicationContext


@SpringBootTest
class GetControllerTest {

    @Autowired
    private lateinit var webApplicationContext: WebApplicationContext

    private lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setup() {
        mockMvc = webAppContextSetup(webApplicationContext).build()
    }

    @Test
    fun `should GET with none`() {
        // Given
        val request = get("/incubator")

        // When
        val resultActions = mockMvc.perform(request).andDo(log())

        // Then
        resultActions
                .andExpect(status().isOk)
                .andExpect(handler().methodName("none"))
                .andExpect(jsonPath("$.accept").isEmpty)
    }

    @Test
    fun `should GET with applicationJson`() {
        // Given
        val accept = "application/json"
        val request = get("/incubator").accept(accept)

        // When
        val resultActions = mockMvc.perform(request).andDo(log())

        // Then
        resultActions
                .andExpect(status().isOk)
                .andExpect(handler().methodName("applicationJson"))
                .andExpect(jsonPath("$.accept").value(accept))
    }

    @Test
    fun `should GET with applicationJsonUtf8`() {
        // Given
        val accept = "application/json;charset=UTF-8"
        val request = get("/incubator").accept(accept)

        // When
        val resultActions = mockMvc.perform(request).andDo(log())

        // Then
        resultActions
                .andExpect(status().isOk)
                .andExpect(handler().methodName("applicationJsonUtf8"))
                .andExpect(jsonPath("$.accept").value(accept))
    }

    @Test
    fun `should GET with applicationHalJson`() {
        // Given
        val accept = "application/hal+json"
        val request = get("/incubator").accept(accept)

        // When
        val resultActions = mockMvc.perform(request).andDo(log())

        // Then
        resultActions
                .andExpect(status().isOk)
                .andExpect(handler().methodName("applicationHalJson"))
                .andExpect(jsonPath("$.accept").value(accept))
    }

    @Test
    fun `should GET with applicationHalJsonUtf8`() {
        // Given
        val accept = "application/hal+json;charset=UTF-8"
        val request = get("/incubator").accept(accept)

        // When
        val resultActions = mockMvc.perform(request).andDo(log())

        // Then
        resultActions
                .andExpect(status().isOk)
                .andExpect(handler().methodName("applicationHalJsonUtf8"))
                .andExpect(jsonPath("$.accept").value(accept))
    }

    @Test
    fun `should GET with applicationHalJsonResponse`() {
        // Given
        val accept = """application/hal+json;profile="https://api.otto.de/api-docs/profiles/response""""
        val request = get("/incubator").accept(accept)

        // When
        val resultActions = mockMvc.perform(request).andDo(log())

        // Then
        resultActions
                .andExpect(status().isOk)
                .andExpect(handler().methodName("applicationHalJsonResponse"))
                .andExpect(jsonPath("$.accept").value(accept))
    }

    @Test
    fun `should GET with applicationHalJsonResponseV2`() {
        // Given
        val accept = """application/hal+json;profile="https://api.otto.de/api-docs/profiles/response-v2""""
        val request = get("/incubator").accept(accept)

        // When
        val resultActions = mockMvc.perform(request).andDo(log())

        // Then
        resultActions
                .andExpect(status().isOk)
                .andExpect(handler().methodName("applicationHalJsonResponseV2"))
                .andExpect(jsonPath("$.accept").value(accept))
    }

    @Test
    fun `should GET with applicationHalJsonResponseVersion1`() {
        // Given
        val accept = """application/hal+json;profile="https://api.otto.de/api-docs/profiles/response";version=1.0"""
        val request = get("/incubator").accept(accept)

        // When
        val resultActions = mockMvc.perform(request).andDo(log())

        // Then
        resultActions
                .andExpect(status().isOk)
                .andExpect(handler().methodName("applicationHalJsonResponseVersion1"))
                .andExpect(jsonPath("$.accept").value(accept))
    }

    @Test
    fun `should GET with applicationHalJsonResponseVersion2`() {
        // Given
        val accept = """application/hal+json;profile="https://api.otto.de/api-docs/profiles/response";version=2.0"""
        val request = get("/incubator").accept(accept)

        // When
        val resultActions = mockMvc.perform(request).andDo(log())

        // Then
        resultActions
                .andExpect(status().isOk)
                .andExpect(handler().methodName("applicationHalJsonResponseVersion2"))
                .andExpect(jsonPath("$.accept").value(accept))
    }

    @Test
    fun `should GET with applicationVendorOtto`() {
        // Given
        val accept = "application/vnd.otto"
        val request = get("/incubator").accept(accept)

        // When
        val resultActions = mockMvc.perform(request).andDo(log())

        // Then
        resultActions
                .andExpect(status().isOk)
                .andExpect(handler().methodName("applicationVendorOtto"))
                .andExpect(jsonPath("$.accept").value(accept))
    }

    @Test
    fun `should GET with applicationVendorOttoJson`() {
        // Given
        val accept = "application/vnd.otto+json"
        val request = get("/incubator").accept(accept)

        // When
        val resultActions = mockMvc.perform(request).andDo(log())

        // Then
        resultActions
                .andExpect(status().isOk)
                .andExpect(handler().methodName("applicationVendorOttoJson"))
                .andExpect(jsonPath("$.accept").value(accept))
    }

    @Test
    fun `should GET with applicationVendorOttoResponseV1Json`() {
        // Given
        val accept = "application/vnd.otto.response.v1+json"
        val request = get("/incubator").accept(accept)

        // When
        val resultActions = mockMvc.perform(request).andDo(log())

        // Then
        resultActions
                .andExpect(status().isOk)
                .andExpect(handler().methodName("applicationVendorOttoResponseV1Json"))
                .andExpect(jsonPath("$.accept").value(accept))
    }

    @Test
    fun `should GET with applicationVendorOttoResponseV2Json`() {
        // Given
        val accept = "application/vnd.otto.response.v2+json"
        val request = get("/incubator").accept(accept)

        // When
        val resultActions = mockMvc.perform(request).andDo(log())

        // Then
        resultActions
                .andExpect(status().isOk)
                .andExpect(handler().methodName("applicationVendorOttoResponseV2Json"))
                .andExpect(jsonPath("$.accept").value(accept))
    }
}
