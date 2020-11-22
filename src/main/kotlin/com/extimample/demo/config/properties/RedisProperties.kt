package com.extimample.demo.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("datasources.redis")
data class RedisProperties(
    var nodes: String = "",
    var readTimeOut: Int = 5000,
    var retryAttempts: Int = 5,
    var retryInterval: Int = 15000,
    var connectionPoolSize: Int = 64,
    var databaseNumber: Int = 0,
    var threads: Int? = null,
    var nettyThreads: Int? = null
)
