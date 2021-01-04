package com.navneet.simplepokedex.model

import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class DogListWrapper (
     val message: Map<String, List<String>>
        ) {
        fun buildBreedJson(): List<BreedJson> {
                val result = mutableListOf<BreedJson>()

                for ((breed, subBreedList) in message) {
                        if (subBreedList.isNullOrEmpty()) {
                                result.add(BreedJson(breed))
                        } else {
                                for (subBreed in subBreedList) {
                                        result.add(BreedJson(breed, subBreed))
                                }
                        }
                }

                result.sort()
                return result
        }
}

data class BreedJson(val breed: String, val subBreed: String? = null) : Comparable<BreedJson> {
        val title: String = if (subBreed.isNullOrEmpty()) breed.capitalize(Locale.CANADA)
        else "${subBreed.capitalize(Locale.CANADA)} ${breed.capitalize(Locale.CANADA)}"

        override fun compareTo(other: BreedJson): Int {
                val breedComp = breed.compareTo(other.breed)
                return if (breedComp != 0) title.compareTo(other.title) else breedComp
        }
}



