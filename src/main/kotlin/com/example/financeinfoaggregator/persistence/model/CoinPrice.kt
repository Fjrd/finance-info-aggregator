package com.example.financeinfoaggregator.persistence.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.Instant
import java.util.*

@Document(collection = "COINS")
data class CoinPrice(
    @Id
    val id: UUID?,
    val name: String,
    val usd: BigDecimal,
    val time: Instant
)