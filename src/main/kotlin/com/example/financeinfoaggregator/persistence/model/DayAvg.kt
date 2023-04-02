package com.example.financeinfoaggregator.persistence.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.util.*

@Document(collection = "COINS")
data class DayAvg(
    @Id
    val id: UUID?,
    val name: String,
    val min: BigDecimal,
    val max: BigDecimal,
    val avg: BigDecimal,
)