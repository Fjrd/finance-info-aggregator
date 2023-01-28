package com.example.financeinfoaggregator.persistence.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class TestModel(
    @Id
    val id: String?,
    val name: String,
    val status: String
)