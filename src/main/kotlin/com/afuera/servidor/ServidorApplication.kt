package com.afuera.servidor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.security.MessageDigest
import java.util.*
import javax.crypto.BadPaddingException
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

@SpringBootApplication
class ServidorApplication

fun main(args: Array<String>) {
	runApplication<ServidorApplication>(*args)

}
