package com.shashinthalk.driverchargingsessionauthenticator.api.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.shashinthalk.driverchargingsessionauthenticator.api.dto.SessionRequestBody
import com.shashinthalk.driverchargingsessionauthenticator.authservice.service.AuthorizationService
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(DriverSessionRequestController::class)
@Import(DriverSessionRequestControllerTest.MockConfig::class)
class DriverSessionRequestControllerTest(
    @Autowired val mockMvc: MockMvc,
    @Autowired val objectMapper: ObjectMapper,
    @Autowired val authorizationService: AuthorizationService,
) {
    companion object {
        private val testDispatcher = StandardTestDispatcher()
    }

    @TestConfiguration
    class MockConfig {
        @Bean
        fun authorizationService(): AuthorizationService = mockk(relaxed = true)

        @Bean
        fun processScopeHandler(): CoroutineScope = CoroutineScope(Dispatchers.Unconfined)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @BeforeEach
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `accept valid session request and call authorization service`() {
        val request =
            SessionRequestBody(
                "b3b4b3b4-3b4b-4b4b-8b4a-3b4e4f4b4b4b",
                "validDriverToken01334",
                "https://webhook.site/60eb45b1-1ae5-4a6c-8a76-16fb6eb2b766",
            )
        val mvcResult =
            mockMvc.post("/driver/session/authenticate") {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(request)
            }
                .andExpect {
                    request { asyncStarted() }
                }
                .andReturn()

        mockMvc.perform(asyncDispatch(mvcResult))
            .andExpect(
                status().isAccepted,
            )
            .andExpect(
                jsonPath("$.status")
                    .value("accepted"),
            )
            .andExpect(
                jsonPath("$.message")
                    .value("Request is being processed asynchronously. The result will be sent to the provided callback URL."),
            )
        coVerify(exactly = 1) { authorizationService.executeAuthorizationRequest(request) }
    }

    @Test
    fun `return bad request for missing driver token`() {
        val invalidRequest =
            mapOf(
                "station_id" to "b3b4b3b4-3b4b-4b4b-8b4a-3b4e4f4b4b4b",
                "callback_url" to "https://webhook.site/60eb45b1-1ae5-4a6c-8a76-16fb6eb2b766",
            )
        mockMvc.post("/driver/session/authenticate") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(invalidRequest)
        }
            .andExpect {
                status { isBadRequest() }
            }
    }
}
