package com.example.lokalinternassignment.domain.models.apiModels

data class Creative(
    val creative_type: Int,
    val `file`: String,
    val image_url: String,
    val order_id: Int,
    val thumb_url: String
)