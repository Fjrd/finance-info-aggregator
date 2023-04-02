package com.example.financeinfoaggregator.service

import com.example.financeinfoaggregator.client.CoingeckoClient
import com.fasterxml.jackson.databind.JsonNode
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class CoinLoaderImpl (
    private val coingeckoClient: CoingeckoClient,
    private val kafkaTemplate: KafkaTemplate<String, JsonNode>
) {
    @Value("\${client.coingecko.coin-ids}")
    lateinit var coinIdsCommaSeparated: String

    @Value("\${spring.kafka.topics.coin-price}")
    lateinit var coinPriceTopicName: String

    @Scheduled(cron = "\${spring.task.scheduling.time.coingecko-fetch}", zone = "Europe/Moscow")
    fun fetchFreshData() {
        val eventMessage = coingeckoClient.simplePrice(coinIdsCommaSeparated, "usd")
        kafkaTemplate.send(coinPriceTopicName, eventMessage)
    }
}