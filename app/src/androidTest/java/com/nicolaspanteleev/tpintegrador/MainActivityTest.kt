package com.nicolaspanteleev.tpintegrador

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Assert.*

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivity_compare(){
        Espresso.onView(
            ViewMatchers.withId(R.id.editText1)
        ).perform(
            ViewActions.clearText()
        ).perform(
            ViewActions.typeText("Probando")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.editText2)
        ).perform(
            ViewActions.clearText()
        ).perform(
            ViewActions.typeText("Probando")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.compare_button)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.textView)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Las cadenas de texto son IGUALES")
            )
        )
    }
}