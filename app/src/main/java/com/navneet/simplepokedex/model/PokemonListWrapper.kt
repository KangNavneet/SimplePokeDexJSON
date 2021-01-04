package com.navneet.simplepokedex.model

import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class PokemonListWrapper (

    val results : List<PokemonInfo>
)

@JsonClass(generateAdapter = true)
data class PokemonInfo (
    val name:String,
    val url :String
        )
{
    val id:String get() = url.substringBefore('/').substringAfter('/')
    val title:String get() = "$id ${name.capitalize(Locale.US)}) "
}

@JsonClass(generateAdapter = true)
data class PokemonImageListWrapper(
        val name : String,
        val sprites:Sprites
)
@JsonClass(generateAdapter = true)
data class Sprites (

     val front_default : String?,
     val front_shiny_female : String?

)
