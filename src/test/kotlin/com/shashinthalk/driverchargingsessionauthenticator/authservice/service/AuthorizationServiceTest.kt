package com.shashinthalk.driverchargingsessionauthenticator.authservice.service

import com.shashinthalk.driverchargingsessionauthenticator.api.dto.SessionRequestBody
import com.shashinthalk.driverchargingsessionauthenticator.authservice.dto.CallbackBody
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers.anyList
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Captor
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.doNothing
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.web.client.RestTemplate
import kotlin.test.Test

@ExtendWith(MockitoExtension::class)
class AuthorizationServiceTest() {
    @Mock
    lateinit var restTemplate: RestTemplate

    @Mock
    lateinit var decisionLogger: DecisionLogger

    @InjectMocks
    lateinit var authService: AuthorizationService

    @Captor
    lateinit var callbackCaptor: ArgumentCaptor<CallbackBody>

    @Test
    fun `fetch data from queue , call callback and save logger`() {
        val request =
            SessionRequestBody(
                "123e4567-e89b-12d3-a456-426614174000",
                "Abcdefghijklmnopqrstu-1234",
                "https://webhook.site/13cd222f-7423-4056-ba73-84cf271a2d3e",
            )

        var responce =
            CallbackBody(
                stationId = request.stationId,
                driverToken = request.driverToken,
                status = "allowed",
            )

        doNothing().`when`(restTemplate).postForLocation(
            anyString(),
            anyString(),
        )
        doNothing().`when`(decisionLogger).saveDecisionLog(
            data = anyList(),
        )

        authService.executeAuthorizationRequest(request)

        verify(restTemplate).postForLocation(
            request.callbackUrl,
            responce,
        )
    }
}
