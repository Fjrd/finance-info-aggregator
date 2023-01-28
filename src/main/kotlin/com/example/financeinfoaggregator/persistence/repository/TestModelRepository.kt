package com.example.financeinfoaggregator.persistence.repository

import com.example.financeinfoaggregator.persistence.model.TestModel
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface TestModelRepository : MongoRepository<TestModel, String> {
}