package com.navneet.simplepokedex.network

import com.navneet.simplepokedex.model.DogListWrapper
import com.navneet.simplepokedex.model.PokemonImageListWrapper
import com.navneet.simplepokedex.model.PokemonListWrapper
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("pokemon/")
    suspend fun getPokemons():PokemonListWrapper

    @GET("breeds/list/all")
    suspend fun getDogs():DogListWrapper



}