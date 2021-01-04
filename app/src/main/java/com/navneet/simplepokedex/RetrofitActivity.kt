package com.navneet.simplepokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_retrofit.*
import kotlinx.coroutines.launch

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        pokemonRecyclerView.layoutManager=LinearLayoutManager(this)



        val apiService = PokemonApplication().serviceLocator.apiService

        enterData4.setOnClickListener {

            lifecycleScope.launch{

                try {
                    val result= apiService.getPokemons()


                    showData4.text=result.results.toString()
                 //  val temp :List<String> = result.results[].toString().split("https://pokeapi.co/api/v2/pokemon/");




                    val adapter=RecyclerViewAdapter()

                    adapter.data = result.results
                    pokemonRecyclerView.adapter=adapter

                }
                catch (e:Exception)
                {
                    Toast.makeText(this@RetrofitActivity,"Failed",Toast.LENGTH_LONG).show()
                    Toast.makeText(this@RetrofitActivity,"$e",Toast.LENGTH_LONG).show()
                }

            }
        }

    }
}