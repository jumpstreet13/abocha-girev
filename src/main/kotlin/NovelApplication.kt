package com.abocha

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

class NovelApplication {
    fun main(args: Array<String>) {
        embeddedServer(Netty, port = 8080) {
            module()
        }.start(wait = true)
    }
}

fun Application.module() {
    configureRouting()
}
