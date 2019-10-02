package com.lambdaschool.guidedcalculator

import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class UtilitiesUnitTest {

    private val validator = mock(Validator::class.java)
    private val utilities = Utilities(validator)

    @Test
    fun utilityCallText() {
        // Setup
        val string = "madam"
        `when`(validator.isStringPalindrome(string)).thenReturn(true)

        // Execute
        val result = utilities.checkIfStringIsPalindrom(string)

        // Check
        assert(result)
    }

    @Test
    fun utilityCallText_Invalid() {
        // Setup
        val string = "windows"
        `when`(validator.isStringPalindrome(string)).thenReturn(false)

        // Execute
        val result = utilities.checkIfStringIsPalindrom(string)

        // Check
        assert(!result)
    }


    // Test Palindromes
    @Test
    fun plaindromeCheck_Valid() {
        // Setup
        val string = "racecar"
        val validator = Validator()

        // Execute
        val result = validator.isStringPalindrome(string)

        // Check
        assert(result)
    }

    @Test
    fun plaindromeCheck_FirstLastMatch() {
        // Setup
        val string = "lambdaschool"
        val validator = Validator()

        // Execute
        val result = validator.isStringPalindrome(string)

        // Check
        assert(!result)
    }

    @Test
    fun plaindromeCheck_Invalid() {
        // Setup
        val string = "android"
        val validator = Validator()

        // Execute
        val result = validator.isStringPalindrome(string)

        // Check
        assert(!result)
    }

    @Test
    fun plaindromeCheck_Spaces() {
        // Setup
        val string = "a man a plan a canal panama"
        val validator = Validator()

        // Execute
        val result = validator.isStringPalindrome(string)

        // Check
        assert(result)
    }

    @Test
    fun plaindromeCheck_Capitals() {
        // Setup
        val string = "lEveL"
        val validator = Validator()

        // Execute
        val result = validator.isStringPalindrome(string)

        // Check
        assert(result)
    }
}