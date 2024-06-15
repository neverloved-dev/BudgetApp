import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.example.databases.UserDatabase
import com.example.models.GenericResponse
import com.example.models.UserEntity
import com.example.models.dto.UserDTO
import com.example.services.UserService
import com.mongodb.client.MongoDatabase
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.JwtRoutes(secret: String, issuer: String, audience: String){
    // Initialize the MongoDB database connection
    val database: MongoDatabase = UserDatabase.database
    val userService = UserService(database)
    routing {
        get("/test"){
            call.respond(HttpStatusCode.OK, GenericResponse<String>(true,"Hello World"))
        }
        post("/token"){
            val user:UserDTO = call.receive()

            val generatedToken = JWT.create()
                .withAudience(audience)
                .withIssuer(issuer)
                .withClaim("userName", user.name)
                .withClaim("email", user.email)
                .withClaim("role",user.role)
                .sign(Algorithm.HMAC512(secret))
            val token = generatedToken
            call.respond(HttpStatusCode.OK,GenericResponse<String>(true,token))
            userService.createUser(user)
        }

        authenticate {
            get("/token"){
                val principal = call.principal<JWTPrincipal>()
                val username = principal!!.payload.getClaim("userName").asString()
                val email = principal.payload.getClaim("email").asString()
                val role = principal.payload.getClaim("role").asString()
                val user = userService.getUserByName(username)
                when(user){
                    null-> call.respond(HttpStatusCode.OK,GenericResponse(true, data ="User not found"))
                    else-> call.respond(HttpStatusCode.OK,GenericResponse(true, data =user))
                }

            }
        }
    }
}