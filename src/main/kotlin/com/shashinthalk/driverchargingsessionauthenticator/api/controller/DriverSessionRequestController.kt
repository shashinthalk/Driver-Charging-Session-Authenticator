package com.shashinthalk.driverchargingsessionauthenticator.api.controller

import com.shashinthalk.driverchargingsessionauthenticator.api.dto.RequestAcknowledgment
import com.shashinthalk.driverchargingsessionauthenticator.api.dto.SessionRequestBody
import com.shashinthalk.driverchargingsessionauthenticator.authservice.service.AuthorizationService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import jakarta.validation.Valid
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * REST controller for driver session - handles charging session validation requests
 * when someone's at a charging station.
 *
 * This provides an endpoint to start a session for
 * checking if the driver is valid, making sure the station and driver are legit
 **/
@RestController
@RequestMapping("/driver/session")
class DriverSessionRequestController(
    private val authorizationService: AuthorizationService,
    private val processScopeHandler: CoroutineScope,
) {
    // Open API Configuration for endpoint response details
    @Operation(summary = "Start a charging session")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "202",
                description = "Request accepted",
                content = [Content(schema = Schema(implementation = RequestAcknowledgment::class))],
            ),
            ApiResponse(
                responseCode = "400",
                description = "Bad request",
                content = [Content(schema = Schema(implementation = RequestAcknowledgment::class))],
            ),
        ],
    )
    /**
     * Authenticates a driver session based on the request
     *
     * @param sessionRequestBody Contains the driver's token, station id and call back url (from the request body).
     * @return An accepted acknowledgment if the request is successfully submitted.
     * @throws Exception if the request is not submitted.
     */
    @PostMapping("/authenticate")
    suspend fun authenticateDriverSessionRequest(
        @Valid @RequestBody sessionRequestBody: SessionRequestBody,
    ): ResponseEntity<RequestAcknowledgment> {
        return try {
            processScopeHandler.launch {
                authorizationService.executeAuthorizationRequest(sessionRequestBody)
            }
            ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(
                    RequestAcknowledgment(
                        status = "accepted",
                        message = "Request is being processed asynchronously. The result will be sent to the provided callback URL.",
                    ),
                )
        } catch (ex: Exception) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                    RequestAcknowledgment(
                        status = "error",
                        message = ex.message.toString(),
                    ),
                )
        }
    }
}
