package com.example

import DatabaseSingleton
import com.example.plugins.*
import com.typesafe.config.ConfigFactory
import configureSecurity
import io.ktor.server.application.*
import io.ktor.server.config.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    val config = HoconApplicationConfig(ConfigFactory.load())
    val secret = config.property("jwt.secret").getString()
    val issuer = config.property("jwt.issuer").getString()
    val audience = config.property("jwt.audience").getString()
    val myRealm = config.property("jwt.realm").getString()
    configureSerialization()
    configureHTTP()
    configureSecurity(secret = secret, issuer = issuer, audience = audience, myRealm = myRealm)
    configureRouting(secret = secret, issuer = issuer, audience = audience)
    DatabaseSingleton.init()
}
