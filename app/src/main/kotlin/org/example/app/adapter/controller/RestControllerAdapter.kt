package org.example.app.adapter.controller

import kotlinx.coroutines.coroutineScope
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient

@RestController
@RequestMapping("/coroutine")
class RestControllerAdapter(
    private val client: WebClient,
) {

    @GetMapping
    suspend fun hello() = coroutineScope {
        Greeting(
            helloWorld = "from app"
        )
    }
}

data class Greeting(
    val helloWorld: String
)