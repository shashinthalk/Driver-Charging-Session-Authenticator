package com.shashinthalk.driver_charging_session_authenticator.api.controller

import com.shashinthalk.driver_charging_session_authenticator.api.dto.RequestAcknowledgment
import com.shashinthalk.driver_charging_session_authenticator.api.dto.SessionRequestBody
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/driver/session")
class DriverSessionRequestController {

    private var queueName: String = "authRequestQueue"
    @Operation(summary = "Start a charging session")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "202",
                description = "Request accepted",
                content = [Content(schema = Schema(implementation = RequestAcknowledgment::class))]
            ),
            ApiResponse(
                responseCode = "400",
                description = "Bad request",
                content = [Content(schema = Schema(implementation = RequestAcknowledgment::class))]
            )
        ]
    )

    @PostMapping("/authenticate")
    suspend fun authenticateDriverSessionRequest(@Valid @RequestBody sessionRequestBody: SessionRequestBody) : ResponseEntity<RequestAcknowledgment>{

        return ResponseEntity.ok(RequestAcknowledgment(
            status = "accepted",
            message = "Request is being processed asynchronously. The result will be sent to the provided callback URL."
        ))

    }

}