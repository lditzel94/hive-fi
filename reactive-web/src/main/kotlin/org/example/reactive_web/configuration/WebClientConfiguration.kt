package org.example.org.example.reactive_web.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
open class WebClientConfiguration {

    @Bean
    open fun webClient(): WebClient {
        return WebClient.builder().build()
    }
}