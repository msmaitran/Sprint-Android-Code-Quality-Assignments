package com.lambdaschool.guidedcalculator

class Utilities(private val validator: Validator) {
    fun checkIfStringIsPalindrom(original: String): Boolean {
        return validator.isStringPalindrome(original)
    }

}