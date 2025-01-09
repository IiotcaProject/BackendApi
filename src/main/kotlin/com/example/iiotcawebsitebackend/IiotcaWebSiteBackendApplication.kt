package com.example.iiotcawebsitebackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class IiotcaWebSiteBackendApplication

fun main(args: Array<String>) {
    runApplication<IiotcaWebSiteBackendApplication>(*args)
}
