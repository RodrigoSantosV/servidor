package com.afuera.servidor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ServidorApplication

fun main(args: Array<String>) {
	runApplication<ServidorApplication>(*args)
}
