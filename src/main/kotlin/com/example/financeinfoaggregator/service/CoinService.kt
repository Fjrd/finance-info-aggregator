package com.example.financeinfoaggregator.service

import com.example.financeinfoaggregator.api.response.CoinPriceResponse
import com.fasterxml.jackson.databind.JsonNode
import java.time.Instant
import java.time.LocalDateTime

interface CoinService {
    fun processCoinEvent(event: JsonNode, timestamp: Instant)
    fun findByPeriod(start: LocalDateTime?, end: LocalDateTime?) : List<CoinPriceResponse>
}