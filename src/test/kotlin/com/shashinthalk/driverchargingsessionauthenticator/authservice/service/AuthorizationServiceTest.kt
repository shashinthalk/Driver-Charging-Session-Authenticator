package com.shashinthalk.driverchargingsessionauthenticator.authservice.service

import com.shashinthalk.driverchargingsessionauthenticator.api.dto.SessionRequestBody
import com.shashinthalk.driverchargingsessionauthenticator.authservice.authenticate.AuthenticateHandler
import com.shashinthalk.driverchargingsessionauthenticator.authservice.dto.CallbackBody
import com.shashinthalk.driverchargingsessionauthenticator.authservice.logger.DecisionLogger
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.http.ResponseEntity
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

class AuthorizationServiceTest {
    private val decisionLogger = mockk<DecisionLogger>(relaxed = true)
    private val webClient = mockk<WebClient>(relaxed = true)
    private val authenticateHandler = mockk<AuthenticateHandler>()
    private lateinit var service: AuthorizationService

    @BeforeEach
    fun setUp() {
        service = AuthorizationService(decisionLogger, webClient, authenticateHandler)
    }

    @Test
    fun `call authenticate and logger`() =
        runTest {
            val request =
                SessionRequestBody(
                    "b3b4b3b4-3b4b-4b4b-8b4a-3b4e4f4b4b4b",
                    "validDriverToken01334",
                    "https://webhook.site/60eb45b1-1ae5-4a6c-8a76-16fb6eb2b766",
                )

            coEvery {
                authenticateHandler.validateDriverAndStationWithAcl(any(), any())
            } returns "allowed"

            val requestBodyUriSpec = mockk<WebClient.RequestBodyUriSpec>(relaxed = true)
            val requestBodySpec = mockk<WebClient.RequestBodySpec>(relaxed = true)
            val responseSpec = mockk<WebClient.ResponseSpec>(relaxed = true)
            val responseEntity = mockk<ResponseEntity<Void>>(relaxed = true)
            var callback =
                CallbackBody(
                    "b3b4b3b4-3b4b-4b4b-8b4a-3b4e4f4b4b4b",
                    "validDriverToken01334",
                    "unknown",
                )
            every { webClient.post() } returns requestBodyUriSpec
            every { requestBodyUriSpec.uri(any<String>()) } returns requestBodySpec
            every { requestBodySpec.bodyValue(any()) } returns requestBodySpec
            every { requestBodySpec.retrieve() } returns responseSpec
            every { responseSpec.toBodilessEntity() } returns Mono.just(responseEntity)
            service.executeAuthorizationRequest(request)
            coVerify {
                authenticateHandler.validateDriverAndStationWithAcl(
                    "b3b4b3b4-3b4b-4b4b-8b4a-3b4e4f4b4b4b",
                    "validDriverToken01334",
                )
            }
            coVerify {
                decisionLogger.saveDecisionLog(
                    data =
                        listOf(callback),
                )
            }
        }
}
