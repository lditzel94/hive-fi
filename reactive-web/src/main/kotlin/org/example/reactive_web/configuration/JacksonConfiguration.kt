package org.example.reactive_web.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SNAKE_CASE
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

@Configuration
open class JacksonConfiguration {
    @Bean
    open fun objectMapper(): ObjectMapper {
        return Jackson2ObjectMapperBuilder()
            .propertyNamingStrategy(SNAKE_CASE)
            .build<ObjectMapper>()
    }
}