package org.example.app.adapter.database

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Table(name = "entity")
data class Entity(@Id val id: Long? = null, val firstName: String)

interface R2dbcExampleRepository : CoroutineCrudRepository<Entity, Long> {}

@Repository
open class R2dbcRepositoryExampleAdapter()