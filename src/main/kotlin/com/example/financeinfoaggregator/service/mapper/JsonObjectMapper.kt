package com.example.financeinfoaggregator.service.mapper

import com.fasterxml.jackson.databind.JsonNode

interface JsonObjectMapper {
    fun mapObjectToJsonNode(obj : Any) : JsonNode
}