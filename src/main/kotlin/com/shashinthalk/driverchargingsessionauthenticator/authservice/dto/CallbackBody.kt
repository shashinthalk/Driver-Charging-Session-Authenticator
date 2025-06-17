package com.shashinthalk.driverchargingsessionauthenticator.authservice.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class CallbackBody(
    @JsonProperty("station_id")
    val stationId: String,
    @JsonProperty("driver_token")
    val driverToken: String,
    @JsonProperty("status")
    val status: String,
)
