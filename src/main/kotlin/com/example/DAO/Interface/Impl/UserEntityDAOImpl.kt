package com.example.DAO.Interface.Impl

import com.example.DAO.Interface.UserEntityDAO
import com.example.models.UserEntity

class UserEntityDAOImpl :UserEntityDAO{
    override suspend fun allExamples(): List<UserEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun exampleEntity(id: Int): UserEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun addNewExample(title: String): UserEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun editExample(id: Int, name: String): UserEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun deleteExample(id: Int) {
        TODO("Not yet implemented")
    }
}