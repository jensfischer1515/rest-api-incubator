package de.otto.rest

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.mock.web.MockServletContext
import org.springframework.web.context.WebApplicationContext


@SpringBootTest
class ApplicationTests {

    @Autowired
    private lateinit var webApplicationContext: WebApplicationContext

    @Test
    fun `should load spring context`() {
        val servletContext = webApplicationContext.servletContext

        then(servletContext).isNotNull
        then(servletContext is MockServletContext).isTrue()
        then(webApplicationContext.getBean("getController")).isNotNull
        then(webApplicationContext.getBean("postController")).isNotNull
    }
}
