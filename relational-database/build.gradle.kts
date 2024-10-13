import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("spring-common-conventions")
    id("database.spring-r2dbc-conventions")
}

group = "dev.luciano"
version = "1.0.0"

tasks.getByName<BootJar>("bootJar") {
    enabled = false
}

// Keep the regular jar task enabled
tasks.getByName<Jar>("jar") {
    enabled = true // This will generate a JAR with Spring dependencies
}