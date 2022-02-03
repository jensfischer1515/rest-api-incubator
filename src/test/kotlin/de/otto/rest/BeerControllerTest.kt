package de.otto.rest


import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.log
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup
import org.springframework.web.context.WebApplicationContext


@SpringBootTest
@ExtendWith(SpringExtension::class)
class BeerControllerTest {

    @Autowired
    private lateinit var webApplicationContext: WebApplicationContext

    private lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setup() {
        mockMvc = webAppContextSetup(webApplicationContext).build()
    }

    @Test
    fun `should GET with beer-jens`() {
        // Given
        val accept = """application/hal+json;profile="https://api.otto.de/api-docs/profiles/beer-jens""""
        val request = get("/beer").accept(accept)

        // When
        val resultActions = mockMvc.perform(request).andDo(log())

        // Then
        resultActions
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.beer").value("Jens zahlt"))
    }

    @Test
    fun `should GET with beer-guido`() {
        // Given
        val accept = """application/hal+json;profile="https://api.otto.de/api-docs/profiles/beer-guido""""
        val request = get("/beer").accept(accept)

        // When
        val resultActions = mockMvc.perform(request).andDo(log())

        // Then
        resultActions
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.beer").value("Guido zahlt"))
    }
}
