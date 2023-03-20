package com.example.financeinfoaggregator.service.mapper

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component

@Component
class JsonObjectMapperImpl : JsonObjectMapper {

    private var objectMapper: ObjectMapper = ObjectMapper()

    override fun mapObjectToJsonNode(obj: Any): JsonNode {
        return objectMapper.valueToTree(obj)
    }
}