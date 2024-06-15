package com.example.databases

import com.example.models.UserEntity
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoDatabase
import io.ktor.server.application.*
import io.ktor.server.config.*
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection

object UserDatabase {
    val connectionString = "mongodb://neverloveddev1:vpZVg1OvPGin6y2Q@localhost:27017/UserDatabase"
    val mongoClient: MongoClient = MongoClients.create(connectionString)
    val database: MongoDatabase = mongoClient.getDatabase("UserCluster")

}
