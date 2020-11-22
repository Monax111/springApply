package com.extimample.demo.db

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface ServiceDescriptorRepository : ReactiveCrudRepository<Service, String>
