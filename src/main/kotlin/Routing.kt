package com.abocha

import io.ktor.http.*
import com.abocha.main
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/books") {
            call.respondText("I will return here list of books")
        }

        get("/bookPart") {
            call.respondText("I will return here part of book")
        }
    }
}



