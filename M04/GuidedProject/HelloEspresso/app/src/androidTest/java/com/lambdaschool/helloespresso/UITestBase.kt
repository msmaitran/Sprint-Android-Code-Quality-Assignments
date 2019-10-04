package com.lambdaschool.helloespresso

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.isRoot

open class UITestBase {
    fun viewPressBack(): ViewInteraction {
        return Espresso.onView(isRoot()).perform(pressBack())
    }

    fun commonViewAction(text: String): Array<ViewAction> {
        return arrayOf(
            clearText(),
            typeText(text),
            closeSoftKeyboard()
        )
    }
}