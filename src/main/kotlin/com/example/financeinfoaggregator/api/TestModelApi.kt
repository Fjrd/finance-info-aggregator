package com.example.financeinfoaggregator.api

import com.example.financeinfoaggregator.persistence.model.TestModel
import com.example.financeinfoaggregator.service.TestModelServiceImpl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/testModel")
class TestModelApi(private val testModelServiceImpl: TestModelServiceImpl) {

    @GetMapping("/test")
    fun findAll(): ResponseEntity<List<TestModel>> {
        return ResponseEntity.ok(testModelServiceImpl.findAll())
    }
}