package com.shashinthalk.driverchargingsessionauthenticator.common.config

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class WebClientConfig {
    @Bean
    fun webClientHandler() : WebClient = WebClient.builder().build()
}