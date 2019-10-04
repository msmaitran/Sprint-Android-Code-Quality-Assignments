package com.lambdaschool.androidtestdrivendesigncalculator

import kotlin.math.absoluteValue

class Math {

    // Calculate the sum of squares of two numbers.
    fun sumofSquares(num1: Int, num2: Int): Int {
        return (num1 * num1) + (num2 * num2)
    }

    // Calculate the absoluteDifference between the absolute values of two numbers.
    fun absoluteDifference(num1: Int, num2: Int): Int {
        return (num1 - num2).absoluteValue
    }

    fun factorial(num1: Int): Int {
        return if (num1 == 1) num1 else num1 * factorial(num1-1)
    }
}