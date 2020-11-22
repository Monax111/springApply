package com.extimample.demo.db

import org.springframework.data.annotation.Id
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("SERVICE_DESCRIPTOR")
class Service (
    @Id
    @Column("NAME")
    val name: String,

    @Column("URI")
    val uri: String

    ) : Persistable<String> {
        override fun getId(): String? = name

        override fun isNew(): Boolean = true
    }