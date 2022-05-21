package com.extimample.demo

fun main() {
    val people = People(
        name ="Ivan",
        age = 31,
        city = "Moscow"
    )
    val result = SomeLogicComponent().score(people)
    println(result)
}


class SomeLogicComponent {

    fun score(people: People): Boolean = people.age >= 21

}

data class People(
    val name: String,
    val age: Int,
    val city: String
)



