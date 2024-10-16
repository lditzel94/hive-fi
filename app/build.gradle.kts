/*
 * This file was generated by the Gradle 'init' task.
 */

group = "dev.luciano"
version = "1.0.0"

plugins {
    id("spring-common-conventions")
    // Adds reactive web dependencies
    id("web.spring-reactive-web-conventions")
    // Adds reactive database dependencies
    id("database.spring-r2dbc-conventions")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    // Adds reactive web config
    implementation(project(":reactive-web"))

    // Adds reactive database config
    implementation(project(":relational-database"))
}