package com.afuera.servidor

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Cargar {
    companion object {
        val logger = LoggerFactory.getLogger(Cargar.javaClass)
    }

    @Bean
    fun initDatabase(studentRepository : CountriesRepository) : CommandLineRunner {
        return CommandLineRunner { args: Array<String?>? ->
            logger.info("Preloading " + studentRepository.save(Country("Paquito", "Chocolatero")))
            logger.info("Preloading " + studentRepository.save(Country("Paqita", "Salas")))
        }

    }

}