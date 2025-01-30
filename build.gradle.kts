
plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
}

group = "com.abocha"
version = "0.0.1"

application {
    /*tasks.withType<Jar> {
        manifest {
            attributes["Main-Class"] = "com.abocha.ApplicationKt"
        }
    }
    mainClass.set("com.abocha.ApplicationKt")*/

    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

/*tasks {
    jar {
        // Добавляем manifest с указанием main класса
        manifest {
            attributes["Main-Class"] = application.mainClass.get()
        }
        // Добавляем все jar-зависимости в jar-архив (очень важно для Render)
        from(configurations.runtimeClasspath.map {
            if(it is File) {
                if (it.isDirectory) it else zipTree(it)
            } else {
                zipTree(it.singleFile)
            }
        })


        // Вариант для включения ресурсов (если нужно)
        from(sourceSets.main.get().resources.srcDirs)
    }
}*/

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.logback.classic)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.config.yaml)
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)
}
