package com.lambdaschool.androidtestdrivendesigncalculator.util

import android.widget.Toast

object Validator {

    fun inputValid(target: String): Boolean {
        val number = target.toIntOrNull()
        return number != null
    }
}