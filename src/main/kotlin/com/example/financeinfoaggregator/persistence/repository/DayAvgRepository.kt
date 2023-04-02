package com.example.financeinfoaggregator.persistence.repository

import com.example.financeinfoaggregator.persistence.model.DayAvg
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface DayAvgRepository : MongoRepository<DayAvg, UUID> {
}