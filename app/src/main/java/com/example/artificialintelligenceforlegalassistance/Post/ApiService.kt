package com.example.artificialintelligenceforlegalassistance.Post

import com.example.artificialintelligenceforlegalassistance.data.Query

import com.example.artificialintelligenceforlegalassistance.data.QueryResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @Headers("Content-Type: application/json")
    @POST("/query")
    fun sendQuery(@Body query: Query): Call<QueryResponse>
}