package com.example.financeinfoaggregator.service

import com.example.financeinfoaggregator.api.response.CoinPriceResponse
import com.example.financeinfoaggregator.persistence.model.CoinPrice
import com.example.financeinfoaggregator.persistence.repository.CoinRepository
import com.fasterxml.jackson.databind.JsonNode
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*
import java.util.stream.Collectors

@Service
class CoinServiceImpl(private val coinRepository: CoinRepository) : CoinService {

    override fun processCoinEvent(event: JsonNode, timestamp: Instant) {
        val list = arrayListOf<CoinPrice>()
        for (name in event.fieldNames()) {
            val price = event.get(name).get("usd").toString().toBigDecimal()
            list.add(CoinPrice(UUID.randomUUID(), name, price, timestamp))
        }
        coinRepository.saveAll(list)
    }

    override fun findByPeriod(start: LocalDateTime?, end: LocalDateTime?): List<CoinPriceResponse> {
        val startTime = Optional.ofNullable(start).orElse(LocalDate.now().atStartOfDay())
        val endTime = Optional.ofNullable(end).orElse(LocalDate.now().plusDays(1).atStartOfDay().minusSeconds(1))
        val coins = coinRepository.findAllByTimeBetweenOrderByTimeAsc(startTime.toInstant(ZoneOffset.UTC), endTime.toInstant(ZoneOffset.UTC))
        val mapGroupedByName = coins.stream()
            .collect(Collectors.groupingBy { it.name })
        val response = arrayListOf<CoinPriceResponse>()
        mapGroupedByName
            .entries
            .parallelStream()
            .map { mapToCoinPriceResponse(it.key, it.value) }
            .forEach(response::add)

        return response
    }

    fun mapToCoinPriceResponse(name: String, list: List<CoinPrice>): CoinPriceResponse {
        val max = list.stream().map { it.usd }.max { o1, o2 -> o1.compareTo(o2) }.get().toDouble()
        val min = list.stream().map { it.usd }.min { o1, o2 -> o1.compareTo(o2) }.get().toDouble()
        val avg = list.stream().mapToDouble { it.usd.toDouble() }.average().asDouble
        return CoinPriceResponse(name, min, max, avg, list)
    }

}