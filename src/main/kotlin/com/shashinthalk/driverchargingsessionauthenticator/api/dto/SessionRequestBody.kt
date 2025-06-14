package com.shashinthalk.driverchargingsessionauthenticator.api.dto

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class SessionRequestBody(
    @JsonProperty("station_id")
    @field:NotBlank(message = "Station id is required")
    @field:Pattern(
        regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[1-5][0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}\$",
        message = "Invalid Id",
    )
    val stationId: String,
    @JsonProperty("driver_token")
    @field:NotBlank(message = "Driver id is required")
    @field:Size(min = 20, max = 80)
    @field:Pattern(
        regexp = "^[A-Za-z0-9\\-._~]{20,80}\$",
        message = "Invalid driver id",
    )
    val driverToken: String,
    @JsonProperty("callback_url")
    @field:NotBlank(message = "Callback url is required")
    @field:Pattern(
        regexp = "^(https?://)[^\\s]+$",
        message = "Callback url must be a valid HTTP or HTTPS",
    )
    val callbackUrl: String,
)
