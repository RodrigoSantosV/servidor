package com.afuera.servidor

import org.springframework.web.bind.annotation.*


@RestController
class CountryController(private val countriesRepository: CountriesRepository) {

    @GetMapping("/countries")
    fun getAllCountries() : List<Country> {
        return countriesRepository.findAll()
    }

    @GetMapping("/country/{id}")
    fun getCountry(@PathVariable id : Long) : Country {
        return countriesRepository.findById(id).get()
    }
    @GetMapping("/countCountries")
    fun getCount() : Long {
        return countriesRepository.count()
    }
}