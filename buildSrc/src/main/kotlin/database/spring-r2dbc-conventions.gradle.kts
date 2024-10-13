package database

plugins {
    id("spring-common-conventions")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("org.postgresql:r2dbc-postgresql")
//    runtimeOnly("org.postgresql:postgresql")
}
