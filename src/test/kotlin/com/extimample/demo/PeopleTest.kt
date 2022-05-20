@file:Suppress("NonAsciiCharacters")

package com.extimample.demo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


class PeopleTest {

    private val someLogicComponent = SomeLogicComponent()

    @Test
    fun `несовершеннолетним отказываем`() {
        val people = People(
            name = "Подросток",
            age = 17,
            city = "none"
        )
        val result = someLogicComponent.score(people)
        Assertions.assertFalse(result)
    }

    @Test
    fun `совершеннолетним одобряем`() {
        val people = People(
            name = "Студент",
            age = 18,
            city = "Общага"
        )
        val result = someLogicComponent.score(people)
        Assertions.assertTrue(result)
    }
}