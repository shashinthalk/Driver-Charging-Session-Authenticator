package com.shashinthalk.driverchargingsessionauthenticator.common.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {
    @Bean
    fun configOpenAPI(): OpenAPI? {
        return OpenAPI()
            .info(
                Info()
                    .title("Chargepoint Driver Charging Session Manager API")
                    .version("1.0.0")
                    .description(
                        "A driver attempts to start a charging session at a specific station by " +
                            "sending an API request to a REST endpoint. The\n" +
                            "request includes unique identifiers for both the station and the driver and a " +
                            "callback URL where the final decision will be\n" +
                            "sent once processing is complete.",
                    ),
            )
    }
}
