package com.navneet.simplepokedex

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView

import com.navneet.simplepokedex.model.PokemonImageListWrapper
import com.navneet.simplepokedex.model.PokemonInfo
import com.navneet.simplepokedex.model.PokemonListWrapper
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_poke_list.view.*
import kotlinx.coroutines.launch

class RecyclerViewAdapter :RecyclerView.Adapter<PokemonViewHolder>() {

    var data:List<PokemonInfo> = emptyList()

    val apiService = PokemonApplication().serviceLocator.apiService

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {

        return PokemonViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {

        //holder.itemView.namePoke.text=data[position].name
        //holder.itemView.urlPoke.text=data[position].url

        holder.bind(data[position],position)



       // holder.itemView.pokeText.text=id.toString()

       // Picasso.get().load(imageData).into(holder.itemView.pokeImage);
    }

    override fun getItemCount(): Int {

        return data.size
    }

}


class PokemonViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)
{
    companion object
    {
        fun from(parent:ViewGroup):PokemonViewHolder
        {
            val layoutInflater=LayoutInflater.from(parent.context)
            val layout=  layoutInflater.inflate(R.layout.activity_poke_list,parent,false)
            return PokemonViewHolder(layout)

        }
    }


    fun bind(pokemonInfo:PokemonInfo,position: Int)
    {
        itemView.urlPoke.text=pokemonInfo.id
        val ans=(position+1).toString() +". "+ pokemonInfo.name.capitalize()
        itemView.namePoke.text=ans

    }

}