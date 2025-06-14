package com.shashinthalk.driver_charging_session_authenticator.api.controller

import com.shashinthalk.driver_charging_session_authenticator.api.dto.RequestAcknowledgment
import com.shashinthalk.driver_charging_session_authenticator.api.dto.SessionRequestBody
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/driver/session")
class DriverSessionRequestController {

    @PostMapping("/authenticate")
    suspend fun authenticateDriverSessionRequest(@Valid @RequestBody sessionRequestBody: SessionRequestBody) : ResponseEntity<RequestAcknowledgment>{

        println("Session request is authenticated")

        return ResponseEntity.ok(RequestAcknowledgment(
            status = "accepted",
            message = "Request is being processed asynchronously. The result will be sent to the provided callback URL."
        ))
    }



}