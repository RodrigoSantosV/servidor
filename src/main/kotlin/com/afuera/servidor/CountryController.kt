package com.afuera.servidor

import org.springframework.web.bind.annotation.*


@RestController
class CountryController(private val CountriesRepository: CountriesRepository) {

    @GetMapping("/countries")
    fun getAllStudents() : List<Country> {
        return CountriesRepository.findAll()
    }

    @PostMapping("/country")
    fun insertStudent(@RequestBody student : Country){
        CountriesRepository.save(student)
    }

    @GetMapping("/country/{id}")
    fun getStudent(@PathVariable id : Long) : Country {
        return CountriesRepository.findById(id).get()
    }

    @DeleteMapping("/country/{id}")
    fun deleteStudent(@PathVariable id : Long){
        CountriesRepository.deleteById(id)
    }
}