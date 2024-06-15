package com.example.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import java.util.UUID

@Serializable
data class UserEntity(
    @BsonId
    @Contextual
    val id:UUID?,
    val name: String,
    val role:String,
    val lastName:String,
    val email:String
)