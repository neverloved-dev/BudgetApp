package com.example.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class BudgetPlan(val int: Int,val minimalSum:Int,val maximumSum:Int,val name:String){
    companion object BudgetPlan: Table(){
        val id = integer("id").autoIncrement()
        val minimalSum = integer("Minimal sum")
        val maximumSum = integer("Maximal sum")
        val name = integer("Plan name")
    }
}