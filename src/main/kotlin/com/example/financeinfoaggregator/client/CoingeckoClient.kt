package com.example.financeinfoaggregator.client

import com.example.financeinfoaggregator.client.dto.CoinDto
import com.fasterxml.jackson.databind.JsonNode
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "CoinGecko", url = "\${client.coingecko.host}")
interface CoingeckoClient {

    @GetMapping("coins/list")
    fun coinList(): List<CoinDto>

    @GetMapping("simple/price")
    fun simplePrice(
        @RequestParam ids : String,
        @RequestParam("vs_currencies") vsCurrency: String
    ): JsonNode
}