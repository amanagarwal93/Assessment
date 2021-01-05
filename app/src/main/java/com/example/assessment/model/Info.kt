package com.example.assessment.model

import java.io.Serializable

data class Info(
    val directors: List<String>,
    val releaseDate: String,
    val rating: Double,
    val genres: List<String>,
    val imageUrl: String,
    val plot: String,
    val rank: Int,
    val runningTime: Int,
    val actors: List<String>
) : Serializable
