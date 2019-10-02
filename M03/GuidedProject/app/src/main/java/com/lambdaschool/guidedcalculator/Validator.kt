package com.lambdaschool.guidedcalculator

class Validator {
    fun isStringPalindrome(original: String): Boolean {
        val adjusted = original.toLowerCase().replace(" ", "")
        val reverse = adjusted.reversed()
        var result = true
        adjusted.forEachIndexed { index, loweredChar ->
            if (loweredChar != reverse[index]) {
                result = false
            }
        }
        return result
    }
}