package com.example.financeinfoaggregator.persistence.repository

import com.example.financeinfoaggregator.persistence.model.CoinPrice
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.time.Instant
import java.util.*

@Repository
interface CoinRepository : MongoRepository<CoinPrice, UUID> {
    fun findAllByTimeBetweenOrderByTimeAsc(start: Instant, end: Instant) : List<CoinPrice>
}