package com.afuera.servidor

import org.springframework.web.bind.annotation.*


@RestController
class CountryController(private val CountriesRepository: CountriesRepository) {

    @GetMapping("/countries")
    fun getAllCountries() : List<Country> {
        return CountriesRepository.findAll()
    }

    @GetMapping("/countCountries")
    fun getCount() : Long {
        return CountriesRepository.count()
    }

    @PostMapping("/country")
    fun insertCountry(@RequestBody student : Country){
        CountriesRepository.save(student)
    }

    @GetMapping("/country/{id}")
    fun getCountry(@PathVariable id : Long) : Country {
        return CountriesRepository.findById(id).get()
    }

    @DeleteMapping("/country/{id}")
    fun deleteCountry(@PathVariable id : Long){
        CountriesRepository.deleteById(id)
    }


}