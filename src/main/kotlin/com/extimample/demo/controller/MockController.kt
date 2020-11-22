package com.extimample.demo.controller

import com.extimample.demo.db.Service
import com.extimample.demo.db.ServiceDescriptorRepository
import org.redisson.api.RedissonReactiveClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RequestMapping("/api/v1")
@RestController
class MockController(
    val redissonReactiveClient: RedissonReactiveClient,
    val serviceDescriptorRepository: ServiceDescriptorRepository
) {


    @PostMapping("/mock/{message}")
    fun createMock(
        @PathVariable("message") serviceName: String
    ): ResponseEntity<String> {

        val bucket = redissonReactiveClient.getBucket<String>("test")
        bucket.set(serviceName)

        serviceDescriptorRepository.save(Service(serviceName, serviceName))

        return ResponseEntity.ok(serviceName)
    }


}
