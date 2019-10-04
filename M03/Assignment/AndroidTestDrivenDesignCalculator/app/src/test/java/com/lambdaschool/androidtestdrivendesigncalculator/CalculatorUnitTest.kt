package com.lambdaschool.androidtestdrivendesigncalculator

import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class CalculatorUnitTest {

    // Write unit tests for verifying both the functions in the Calculator class.
    // The unit tests should use a mock object for the Math class.
    // The unit tests should have mock implementation for the functions defined in the Math class.
    private val math = mock(Math::class.java)
    private val calculator = Calculator(math)

    @Test
    fun calculatorSumSquares() {
        // Setup
        val num1 = 2
        val num2 = 4
        val expected = 20
        `when`(math.sumofSquares(num1, num2)).thenReturn(expected)

        // Execute
        val sumSquares = calculator.sumSquares(num1, num2)

        // Check
        assertEquals(expected, sumSquares)
    }

    @Test
    fun calculatorAbsoluteDifference() {
        // Setup
        val num1 = 2
        val num2 = 10
        val expected = 8
        `when`(math.absoluteDifference(num1, num2)).thenReturn(expected)

        // Execute
        val absoluteDifference = calculator.absoluteDifference(num1, num2)

        // Check
        assertEquals(expected, absoluteDifference)
    }

    @Test
    fun calculatorFactorial() {
        // Setup
        val num1 = 4
        val expected = 24
        `when`(math.factorial(num1)).thenReturn(expected)

        // Execute
        val factorial = calculator.factorial(num1)

        // Check
        assertEquals(expected, factorial)
    }
}