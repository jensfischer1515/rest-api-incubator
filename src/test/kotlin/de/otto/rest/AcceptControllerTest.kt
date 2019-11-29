package de.otto.rest

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.log
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup
import org.springframework.web.context.WebApplicationContext


@SpringBootTest
@RunWith(SpringRunner::class)
class AcceptControllerTest {

    @Autowired
    private lateinit var webApplicationContext: WebApplicationContext

    private lateinit var mockMvc: MockMvc

    @Before
    fun setup() {
        mockMvc = webAppContextSetup(webApplicationContext).build()
    }

    @Test
    fun `should invoke none`() {

        // When
        val resultActions = mockMvc
                .perform(get("/accept"))
                .andDo(log())

        // Then
        resultActions
				.andExpect(status().isOk)
                .andExpect(handler().methodName("none"))
                .andExpect(jsonPath("$.accept").isEmpty)
    }

	@Test
	fun `should invoke applicationJson`() {
		// Given
		val accept = "application/json"

		// When
		val resultActions = mockMvc
				.perform(get("/accept").accept(accept))
				.andDo(log())

		// Then
		resultActions
				.andExpect(status().isOk)
				.andExpect(handler().methodName("applicationJson"))
				.andExpect(jsonPath("$.accept").value(accept))
	}

	@Test
	fun `should invoke applicationJsonUtf8`() {
		// Given
		val accept = "application/json;charset=UTF-8"

		// When
		val resultActions = mockMvc
				.perform(get("/accept").accept(accept))
				.andDo(log())

		// Then
		resultActions
				.andExpect(status().isOk)
				.andExpect(handler().methodName("applicationJsonUtf8"))
				.andExpect(jsonPath("$.accept").value(accept))
	}

	@Test
	fun `should invoke applicationHalJson`() {
		// Given
		val accept = "application/hal+json"

		// When
		val resultActions = mockMvc
				.perform(get("/accept").accept(accept))
				.andDo(log())

		// Then
		resultActions
				.andExpect(status().isOk)
				.andExpect(handler().methodName("applicationHalJson"))
				.andExpect(jsonPath("$.accept").value(accept))
	}

	@Test
	fun `should invoke applicationHalJsonUtf8`() {
		// Given
		val accept = "application/hal+json;charset=UTF-8"

		// When
		val resultActions = mockMvc
				.perform(get("/accept").accept(accept))
				.andDo(log())

		// Then
		resultActions
				.andExpect(status().isOk)
				.andExpect(handler().methodName("applicationHalJsonUtf8"))
				.andExpect(jsonPath("$.accept").value(accept))
	}

	@Test
	fun `should invoke applicationHalJsonProfile`() {
		// Given
		val accept = """application/hal+json;profile="https://api.otto.de/api-docs/profiles/incubator""""

		// When
		val resultActions = mockMvc
				.perform(get("/accept").accept(accept))
				.andDo(log())

		// Then
		resultActions
				.andExpect(status().isOk)
				.andExpect(handler().methodName("applicationHalJsonProfile"))
				.andExpect(jsonPath("$.accept").value(accept))
	}

	@Test
	fun `should invoke applicationHalJsonProfileVersion1`() {
		// Given
		val accept = """application/hal+json;profile="https://api.otto.de/api-docs/profiles/incubator";version=1.0"""

		// When
		val resultActions = mockMvc
				.perform(get("/accept").accept(accept))
				.andDo(log())

		// Then
		resultActions
				.andExpect(status().isOk)
				.andExpect(handler().methodName("applicationHalJsonProfileVersion1"))
				.andExpect(jsonPath("$.accept").value(accept))
	}

	@Test
	fun `should invoke applicationHalJsonProfileVersion2`() {
		// Given
		val accept = """application/hal+json;profile="https://api.otto.de/api-docs/profiles/incubator";version=2.0"""

		// When
		val resultActions = mockMvc
				.perform(get("/accept").accept(accept))
				.andDo(log())

		// Then
		resultActions
				.andExpect(status().isOk)
				.andExpect(handler().methodName("applicationHalJsonProfileVersion2"))
				.andExpect(jsonPath("$.accept").value(accept))
	}

	@Test
	fun `should invoke applicationVendorOtto`() {
		// Given
		val accept = "application/vnd.otto"

		// When
		val resultActions = mockMvc
				.perform(get("/accept").accept(accept))
				.andDo(log())

		// Then
		resultActions
				.andExpect(status().isOk)
				.andExpect(handler().methodName("applicationVendorOtto"))
				.andExpect(jsonPath("$.accept").value(accept))
	}

	@Test
	fun `should invoke applicationVendorOttoJson`() {
		// Given
		val accept = "application/vnd.otto+json"

		// When
		val resultActions = mockMvc
				.perform(get("/accept").accept(accept))
				.andDo(log())

		// Then
		resultActions
				.andExpect(status().isOk)
				.andExpect(handler().methodName("applicationVendorOttoJson"))
				.andExpect(jsonPath("$.accept").value(accept))
	}

	@Test
	fun `should invoke applicationVendorOttoIncubatorV1Json`() {
		// Given
		val accept = "application/vnd.otto.incubator.v1+json"

		// When
		val resultActions = mockMvc
				.perform(get("/accept").accept(accept))
				.andDo(log())

		// Then
		resultActions
				.andExpect(status().isOk)
				.andExpect(handler().methodName("applicationVendorOttoIncubatorV1Json"))
				.andExpect(jsonPath("$.accept").value(accept))
	}

	@Test
	fun `should invoke applicationVendorOttoIncubatorV2Json`() {
		// Given
		val accept = "application/vnd.otto.incubator.v2+json"

		// When
		val resultActions = mockMvc
				.perform(get("/accept").accept(accept))
				.andDo(log())

		// Then
		resultActions
				.andExpect(status().isOk)
				.andExpect(handler().methodName("applicationVendorOttoIncubatorV2Json"))
				.andExpect(jsonPath("$.accept").value(accept))
	}
}
