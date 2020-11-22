package com.extimample.demo.config

import com.extimample.demo.config.properties.RedisProperties
import org.redisson.Redisson
import org.redisson.api.RedissonReactiveClient
import org.redisson.config.Config
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RedisConfiguration {

    @Bean
    fun redissonConfig(redisProperties: RedisProperties) =
        Config().also { config ->
            val nodesAddresses = redisProperties.nodes.split(";")
            config.useReplicatedServers().apply {
                timeout = redisProperties.readTimeOut
                retryAttempts = redisProperties.retryAttempts
                retryInterval = redisProperties.retryInterval
                slaveConnectionPoolSize = redisProperties.connectionPoolSize
                database = redisProperties.databaseNumber
                nodesAddresses.forEach { node -> addNodeAddress("redis://$node") }
            }

            redisProperties.threads?.let { config.threads = it }
            redisProperties.nettyThreads?.let { config.nettyThreads = it }
        }

    @Bean(destroyMethod = "shutdown")
    fun reactiveRedissonClient(config: Config): RedissonReactiveClient = Redisson.createReactive(config)
}
