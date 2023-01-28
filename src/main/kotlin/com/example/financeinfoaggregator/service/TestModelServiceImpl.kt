package com.example.financeinfoaggregator.service

import com.example.financeinfoaggregator.persistence.model.TestModel
import com.example.financeinfoaggregator.persistence.repository.TestModelRepository
import org.springframework.stereotype.Service

@Service
class TestModelServiceImpl(private val testModelRepository: TestModelRepository) {

    fun findAll(): List<TestModel> {
        return testModelRepository.findAll();
    }
}