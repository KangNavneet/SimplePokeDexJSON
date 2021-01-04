package com.navneet.simplepokedex

import android.app.Application

class PokemonApplication:Application() {
    val serviceLocator=ServiceLocator()
}