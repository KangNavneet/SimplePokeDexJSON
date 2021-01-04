package com.navneet.simplepokedex

import com.navneet.simplepokedex.model.BreedJson

class BreedClick(private val breedClick: (breedJson: BreedJson) -> Unit) {
    fun breedClickListener(data: BreedJson) = breedClick(data)
}