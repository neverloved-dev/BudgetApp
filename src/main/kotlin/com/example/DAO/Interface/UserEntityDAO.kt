package com.example.DAO.Interface

import com.example.models.UserEntity

interface UserEntityDAO {
    suspend fun allExamples(): List<UserEntity>
    suspend fun exampleEntity(id: Int): UserEntity?
    suspend fun addNewExample(title: String): UserEntity?
    suspend fun editExample(id: Int, name:String): UserEntity?
    suspend fun deleteExample(id: Int):Unit
}