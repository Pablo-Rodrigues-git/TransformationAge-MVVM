package com.training.ui.transformationage.data

class DogsManager {

    private val dogs = listOf<Dog>(
        Dog(id = 0, text = "Dog1"),
        Dog(id = 1, text = "Dog2"),
        Dog(id = 2, text = "Dog3"),
        Dog(id = 3, text = "Dog4"),
        Dog(id = 4, text = "Dog5")
    )

    fun getDog() = dogs
}