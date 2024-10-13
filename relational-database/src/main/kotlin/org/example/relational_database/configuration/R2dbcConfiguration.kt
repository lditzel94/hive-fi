package org.example.relational_database.configuration

import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import io.r2dbc.spi.ConnectionFactoryOptions
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.r2dbc.connection.R2dbcTransactionManager
import org.springframework.transaction.ReactiveTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableR2dbcRepositories("org.example")
@EnableTransactionManagement
open class R2dbcConfiguration {
    private val POSTGRES_HOST = System.getenv("POSTGRES_HOST") ?: "localhost"
    private val POSTGRES_PORT = System.getenv("POSTGRES_PORT")?.toInt() ?: 5432
    private val POSTGRES_DB: String = System.getenv("POSTGRES_DB") ?: "postgres"
    private val POSTGRES_USER: String = System.getenv("POSTGRES_USER") ?: "postgres"
    private val POSTGRES_PASSWORD: String = System.getenv("POSTGRES_PASSWORD") ?: "secret"

    @Bean
    open fun connectionFactory(): ConnectionFactory =
        ConnectionFactoryOptions.builder()
            .option(ConnectionFactoryOptions.DRIVER, "postgresql")
            .option(ConnectionFactoryOptions.HOST, POSTGRES_HOST)
            .option(ConnectionFactoryOptions.PORT, POSTGRES_PORT)
            .option(ConnectionFactoryOptions.DATABASE, POSTGRES_DB)
            .option(ConnectionFactoryOptions.USER, POSTGRES_USER)
            .option(ConnectionFactoryOptions.PASSWORD, POSTGRES_PASSWORD)
            .build()
            .let { options -> ConnectionFactories.get(options) }

    @Bean
    open fun r2dbcEntityTemplate(connectionFactory: ConnectionFactory): R2dbcEntityTemplate {
        return R2dbcEntityTemplate(connectionFactory)
    }

    @Bean
    open fun transactionManager(connectionFactory: ConnectionFactory): ReactiveTransactionManager {
        return R2dbcTransactionManager(connectionFactory)
    }
}