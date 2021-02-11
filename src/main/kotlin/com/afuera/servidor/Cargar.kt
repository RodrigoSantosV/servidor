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
    fun initDatabase(CountriesRepository : CountriesRepository) : CommandLineRunner {
        return CommandLineRunner { args: Array<String?>? ->
            logger.info("Preloading " + CountriesRepository.save(Country("Afghanistan", "AF")))
            logger.info("Preloading " + CountriesRepository.save(Country("Åland Islands", "AX")))
            logger.info("Preloading " + CountriesRepository.save(Country("Albania", "AL")))
            logger.info("Preloading " + CountriesRepository.save(Country("Algeria", "DZ")))
            logger.info("Preloading " + CountriesRepository.save(Country("American Samoa", "AS")))
            logger.info("Preloading " + CountriesRepository.save(Country("Wallis and Futuna", "WF")))
            logger.info("Preloading " + CountriesRepository.save(Country("Western Sahara", "Western Sahara")))
            logger.info("Preloading " + CountriesRepository.save(Country("Yemen", "YE")))
            logger.info("Preloading " + CountriesRepository.save(Country("Zambia", "ZM")))
            logger.info("Preloading " + CountriesRepository.save(Country("Zimbabwe", "ZW")))
        }

    }

}