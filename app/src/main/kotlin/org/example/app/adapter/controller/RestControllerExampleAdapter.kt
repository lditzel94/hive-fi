package org.example.app.adapter.controller

import kotlinx.coroutines.coroutineScope
import org.example.app.adapter.database.Entity
import org.example.app.adapter.database.R2dbcExampleRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/coroutine")
class RestControllerAdapter(
    private val repository: R2dbcExampleRepository,
) {

    @GetMapping
    suspend fun hello() = coroutineScope {
        Greeting(
            helloWorld = "from app"
        )
    }

    @PostMapping
    suspend fun insertAny() = repository.save(Entity(firstName = "John Doe"))
}

data class Greeting(
    val helloWorld: String
)