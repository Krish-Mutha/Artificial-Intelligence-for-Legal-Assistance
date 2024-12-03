package com.example.artificialintelligenceforlegalassistance.data

data class Query(val query: String)

data class SimilarDocument(
    val title: String,
    val year: Int,
    val judges: String,
    val summary: String
)

data class QueryResponse(
    val similar_documents: List<SimilarDocument>
)