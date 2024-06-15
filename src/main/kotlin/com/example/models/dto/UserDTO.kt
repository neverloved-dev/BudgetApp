package com.example.models.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserDTO(
    val name: String,
    val role:String,
    val lastName:String,
    val email:String
)