package com.afuera.servidor

import org.springframework.web.bind.annotation.*


@RestController
class CountryController(private val countriesRepository: CountriesRepository) {

    @GetMapping("/countries")
    fun getAllCountries() : List<Country> {
        return countriesRepository.findAll()
    }

    @GetMapping("/countCountries")
    fun getCount() : Long {
        return countriesRepository.count()
    }

    @PostMapping("/country")
    fun insertCountry(@RequestBody student : Country){
        countriesRepository.save(student)
    }

    @GetMapping("/country/{id}")
    fun getCountry(@PathVariable id : Long) : Country {
        Cargar.logger.info("Se ha recibido un un $id")
        return countriesRepository.findById(id).get()
    }

    @DeleteMapping("/country/{id}")
    fun deleteCountry(@PathVariable id : Long){
        countriesRepository.deleteById(id)
    }


}