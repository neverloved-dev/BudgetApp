package com.example.services

import com.example.models.UserEntity
import com.example.models.dto.UserDTO
import com.mongodb.client.MongoDatabase
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.bson.Document
import org.litote.kmongo.findOne
import org.litote.kmongo.json

class UserService (private val database: MongoDatabase){

    val personCollection = database.getCollection("UserCollection")
    fun createUser(requestDTO: UserDTO):Document{
        val user:UserEntity = UserEntity(null,requestDTO.role,requestDTO.lastName,requestDTO.email,requestDTO.email)
        personCollection.insertOne(Document.parse(Json.encodeToString(user)))
        return Document.parse(Json.encodeToString(user))
    }

    fun getUserByName(name:String):Document?{
        val userEntity = personCollection.findOne(name)
        return when(userEntity){
            null-> Document.parse("{mesasge:User not found}")
            else-> userEntity
        }
    }
}