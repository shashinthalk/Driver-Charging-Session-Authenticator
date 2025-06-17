package com.shashinthalk.driverchargingsessionauthenticator.authservice.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class AclRecordBody(
    @JsonProperty("station_id")
    val stationId: String,
    @JsonProperty("driver_token")
    val driverToken: String,
)
