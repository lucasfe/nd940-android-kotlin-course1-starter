package com.udacity.shoestore.screens.shoelist

import com.udacity.shoestore.models.Shoe

class ShoeManager {

    companion object {
        fun loadShoes(): ArrayList<Shoe> {
            return arrayListOf(
                Shoe(
                    "Air Jordan 1",
                    10.0,
                    "Nike",
                    "Air Jordan University Blue",
                    listOf("Image 1", "Image 2")
                ),
                Shoe(
                    "Air Max 3",
                    10.0, "Nike",
                    "Hot Lime",
                    listOf("Image 1", "Image 2")
                ),
                Shoe(
                    "Air Force 1 Low",
                    10.0,
                    "Nike",
                    "3M Snake",
                    listOf("Image 1", "Image 2")
                ),
                Shoe(
                    "Air Jordan 4",
                    10.0,
                    "Nike",
                    "Something",
                    listOf("Image 1", "Image 2")
                )
            )
        }
    }
}

