package com.shashinthalk.driver_charging_session_authenticator.common.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.context.annotation.Configuration

@Configuration
class JacksonConfig {
    @Bean
    fun objectMapper(builder: Jackson2ObjectMapperBuilder): ObjectMapper =
        builder
            .propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
            .build<ObjectMapper>()

    @Bean
    fun jackson2JsonMessageConverter() = Jackson2JsonMessageConverter()
}