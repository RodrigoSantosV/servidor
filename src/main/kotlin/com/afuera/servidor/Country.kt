package com.afuera.servidor

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Country(var nombre : String,var codigo :String) {

    @Id
    @GeneratedValue

    private val id:Long? = null

    override fun equals(other: Any?): Boolean {
        if (other is Country){
            return other.id == id && id != null
        }else{
            return false
        }

        return super.equals(other)
    }

    override fun hashCode(): Int {
        return Objects.hash(id, nombre, codigo)
    }
    override fun toString(): String {
        return "$id es el pais $nombre con primer codigo $codigo"
    }
}