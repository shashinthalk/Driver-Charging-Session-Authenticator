package com.shashinthalk.driverchargingsessionauthenticator.api.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.shashinthalk.driverchargingsessionauthenticator.api.dto.SessionRequestBody
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import kotlin.test.Test

@WebMvcTest(controllers = [DriverSessionRequestController::class])
class DriverSessionRequestControllerTest(
    @Autowired private val objectMapper: ObjectMapper,
    @Autowired private val mockMvc: MockMvc,
) {
    @Test
    fun `should accept valid session request`() {
        val requestBody =
            SessionRequestBody(
                "123e4567-e89b-12d3-a456-426614174000",
                "Abcdefghijklmnopqrstu-1234",
                "https://webhook.site/13cd222f-7423-4056-ba73-84cf271a2d3e",
            )

        mockMvc.perform(
            post("/driver/session/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestBody)),
        )
            .andExpect(status().isAccepted)
            .andExpect(jsonPath("$.status").value("accepted"))
            .andExpect(
                jsonPath(
                    "$.message",
                ).value("Request is being processed asynchronously. The result will be sent to the provided callback URL."),
            )
    }
}
