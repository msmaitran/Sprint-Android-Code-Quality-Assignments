package com.lambdaschool.guidedcalculator

import junit.framework.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MathUnitTest {

    private val math = mock(Math::class.java)
    private val calculator = Calculator(math)

    @Test
    fun calculatorAddition() {
        // Setup
        val num1 = 10
        val num2 = 17
        val expected = 27

        `when`(math.addIntegers(num1, num2)).thenReturn(expected)

        // Execute
        val sum = calculator.add(num1, num2)

        // Check
        assertEquals(expected, sum)
    }

    @Test
    fun viewModelSummation() {
        // Setup
        val num1 = 0
        val num2 = 7
        val expected = 7

        val viewModel = CalculatorViewModel()
/*        viewModel.calculator = calculator
        `when`(math.addIntegers(num1, num2)).thenReturn(expected)*/
        val calculator = mock(Calculator::class.java)
        `when`(calculator.add(num1, num2)).thenReturn(expected)
        viewModel.calculator = calculator

        // Execute
        val sum = viewModel.summation(num1, num2)

        // Check
        assertEquals(expected, sum)
    }

    @Test
    fun testAddIntegers() {
        // Setup the conditions of the test
        val num1 = 1
        val num2 = 5
        val expected = 6
        val math = Math()

        // Execute the code under test
        val sum = math.addIntegers(num1, num2)

        // Check by making assertions on result
        assertEquals(expected, sum)
    }

    @Test
    fun testMultiplyIntegers() {
        // Setup
        val num1 = 5
        val num2 = 20
        val expected = 100
        val math = Math()

        // Execute
        val product = math.multiplyIntegers(num1, num2)

        // Check
        assertEquals(expected, product)
    }
}