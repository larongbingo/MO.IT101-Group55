package org.motorph.employee.login

import at.favre.lib.crypto.bcrypt.BCrypt
import org.motorph.employees.crypto.StringHashing

class BcryptStringHashing : StringHashing {
    override fun hash(plaintext: String): String =
        BCrypt.withDefaults().hashToString(12, plaintext.toCharArray())

    override fun verify(plaintext: String, hash: String): Boolean =
        BCrypt.verifyer().verify(plaintext.toCharArray(), hash).verified
}