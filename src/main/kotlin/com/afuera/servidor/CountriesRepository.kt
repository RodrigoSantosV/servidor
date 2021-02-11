package com.afuera.servidor

import org.springframework.data.jpa.repository.JpaRepository

interface CountriesRepository : JpaRepository<Country, Long>