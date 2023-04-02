package com.example.financeinfoaggregator.client.kafka.consumers

import com.example.financeinfoaggregator.service.CoinService
import com.fasterxml.jackson.databind.JsonNode
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.handler.annotation.Headers
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class CoinConsumer(
    private val coinService: CoinService
) {

    @Value("\${spring.kafka.topics.coin-price}")
    lateinit var coinPriceTopicName: String

    @KafkaListener(topics = ["\${spring.kafka.topics.coin-price}"])
    fun handleEvent(@Payload event: JsonNode, @Headers headers: MessageHeaders) {
        var timestamp = Instant.ofEpochMilli((headers.get("kafka_receivedTimestamp") as Long).toLong())
        coinService.processCoinEvent(event, timestamp)
    }
}