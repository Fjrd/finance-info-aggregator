package com.example.financeinfoaggregator.api

import com.example.financeinfoaggregator.api.response.CoinPriceResponse
import com.example.financeinfoaggregator.service.CoinService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/coins")
class CoinsApi(private val coinService: CoinService) {

    @GetMapping("/by-period")
    fun findAll(@RequestParam("start") start : LocalDateTime?, @RequestParam("end") end : LocalDateTime?): ResponseEntity<List<CoinPriceResponse>> {
        return ResponseEntity.ok(coinService.findByPeriod(start, end))
    }
}