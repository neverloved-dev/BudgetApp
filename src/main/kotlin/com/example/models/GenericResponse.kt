package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class GenericResponse<T>(val isSuccess:Boolean, val data:T)