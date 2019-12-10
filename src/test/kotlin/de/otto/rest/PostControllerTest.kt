package de.otto.rest

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.log
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup
import org.springframework.web.context.WebApplicationContext


@SpringBootTest
@RunWith(SpringRunner::class)
class PostControllerTest {

    @Autowired
    private lateinit var webApplicationContext: WebApplicationContext

    private lateinit var mockMvc: MockMvc

    @Before
    fun setup() {
        mockMvc = webAppContextSetup(webApplicationContext).build()
    }

    //@Test
    fun `should POST with none`() {
        // Given
        val request = post("/incubator").content("""{"value":"none"}""")

        // When
        val resultActions = mockMvc.perform(request).andDo(log())

        // Then
        resultActions
                .andExpect(status().isUnsupportedMediaType)
                .andExpect(handler().methodName("none"))
    }

    @Test
    fun `should POST with applicationJson`() {
        // Given
        val contentType = "application/json"
        val request = post("/incubator").content("""{"value":"$contentType"}""").contentType(contentType)

        // When
        val resultActions = mockMvc.perform(request).andDo(log())

        // Then
        resultActions
                .andExpect(status().isOk)
                .andExpect(handler().methodName("applicationJson"))
                .andExpect(jsonPath("$.contentType").value(contentType))
                .andExpect(jsonPath("$.requestPayload").value(contentType))
    }

	@Test
	fun `should POST with applicationJsonUtf8`() {
		// Given
		val contentType = "application/json;charset=UTF-8"
		val request = post("/incubator").content("""{"value":"$contentType"}""").contentType(contentType)

		// When
		val resultActions = mockMvc.perform(request).andDo(log())

		// Then
		resultActions
				.andExpect(status().isOk)
				.andExpect(handler().methodName("applicationJsonUtf8"))
				.andExpect(jsonPath("$.contentType").value(contentType))
				.andExpect(jsonPath("$.requestPayload").value(contentType))
	}

	@Test
	fun `should POST with applicationJsonRequestVersion1`() {
		// Given
		val contentType = """application/json;charset=UTF-8;profile="https://api.otto.de/api-docs/profiles/request";version=1.0"""
		val request = post("/incubator").content("""{"value":"$contentType"}""").contentType(contentType)

		// When
		val resultActions = mockMvc.perform(request).andDo(log())

		// Then
		resultActions
				.andExpect(status().isOk)
				.andExpect(handler().methodName("applicationJsonRequestVersion1"))
				.andExpect(jsonPath("$.contentType").value(contentType))
				.andExpect(jsonPath("$.requestPayload").value(contentType))
	}
}
