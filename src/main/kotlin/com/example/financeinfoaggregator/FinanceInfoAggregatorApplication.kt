package com.example.financeinfoaggregator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@EnableFeignClients
@SpringBootApplication
class FinanceInfoAggregatorApplication

fun main(args: Array<String>) {
    runApplication<FinanceInfoAggregatorApplication>(*args)
}
