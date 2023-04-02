package com.example.financeinfoaggregator.api.response

import com.example.financeinfoaggregator.persistence.model.CoinPrice

data class CoinPriceResponse(
    val name: String,
    val min: Double,
    val max: Double,
    val avg: Double,
    val data: List<CoinPrice>
)
