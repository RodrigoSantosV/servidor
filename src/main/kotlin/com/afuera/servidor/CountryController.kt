package com.afuera.servidor

import org.springframework.web.bind.annotation.*
import java.security.MessageDigest
import java.util.*
import javax.crypto.BadPaddingException
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

private fun cifrar(textoEnString : String, llaveEnString : String) : String {
    println("Voy a cifrar $textoEnString")
    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    cipher.init(Cipher.ENCRYPT_MODE, getKey(llaveEnString))
    val textCifrado = Base64.getEncoder().encodeToString(cipher.doFinal(textoEnString.toByteArray(Charsets.UTF_8)))
    println("He obtenido $textCifrado")
    return textCifrado
}

@Throws(BadPaddingException::class)
private fun descifrar(textoCifrrado : String, llaveEnString : String) : String {
    println("Voy a descifrar $textoCifrrado")
    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    cipher.init(Cipher.DECRYPT_MODE, getKey(llaveEnString));
    val textDescifrado = String(cipher.doFinal(Base64.getDecoder().decode(textoCifrrado)))
    println("He obtenido $textDescifrado")
    return textDescifrado
}


private fun getKey(llaveEnString : String): SecretKeySpec {
    var llaveUtf8 = llaveEnString.toByteArray(Charsets.UTF_8)
    val sha = MessageDigest.getInstance("SHA-1")
    llaveUtf8 = sha.digest(llaveUtf8)
    llaveUtf8 = llaveUtf8.copyOf(16)
    return SecretKeySpec(llaveUtf8, "AES")
}


@RestController
class CountryController(private val countriesRepository: CountriesRepository) {

    @GetMapping("/countries")
    fun getAllCountries() : List<Country> {
        return countriesRepository.findAll()
    }

    @GetMapping("/country/{id}")
    fun getCountry(@PathVariable id : Long) : Country {
        val encriptador = id.toString()
        val llave = "elpepe"
        val descifrador = descifrar(cifrar(encriptador,llave),llave)

        return countriesRepository.findById(descifrador.toLong()).get()
    }
    @GetMapping("/countCountries")
    fun getCount() : Long {
        return countriesRepository.count()
    }

}