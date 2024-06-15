package com.example.plugins

import JwtRoutes
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting(secret: String, issuer: String, audience: String) {
    JwtRoutes(secret, issuer, audience)
}
