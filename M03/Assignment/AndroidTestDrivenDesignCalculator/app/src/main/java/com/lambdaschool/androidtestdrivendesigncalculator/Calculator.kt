package com.lambdaschool.androidtestdrivendesigncalculator

// Build a Calculator class with a constructor injected parameter of type Math (which is another class)
class Calculator(private val math: Math) {

    // The first function should be named sumSquares that accepts one parameter that calls the corresponding function in the Math class.
    fun sumSquares(num1: Int, num2: Int): Int {
        return math.sumofSquares(num1, num2)
    }

    // The second function should be named absoluteDifference that accepts two parameters that calls the corresponding function in the Math class.
    fun absoluteDifference(num1: Int, num2: Int): Int {
        return math.absoluteDifference(num1, num2)
    }

    fun factorial(num1: Int): Int {
        return math.factorial(num1)
    }
}