package com.example.financeinfoaggregator.service

import com.example.financeinfoaggregator.persistence.repository.DayAvgRepository
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class DayAvgService(private val dayAvgRepository: DayAvgRepository,
                    private val coinService: CoinService) {

    @Scheduled(cron = "\${spring.task.scheduling.time.calc-day-avg}", zone = "Europe/Moscow")
    fun fetchFreshData() {
        val map = coinService.findByPeriod(null, null)
            .stream()
            .collect(Collectors.groupingBy { it.name })
    }

}