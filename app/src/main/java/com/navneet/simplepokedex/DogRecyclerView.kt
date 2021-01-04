package com.navneet.simplepokedex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.navneet.simplepokedex.model.BreedJson
import com.navneet.simplepokedex.model.DogListWrapper
import com.navneet.simplepokedex.model.PokemonInfo
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_poke_list.view.*
import kotlinx.android.synthetic.main.dog_list.view.*

class DogRecyclerView(private val breedClick: BreedClick):RecyclerView.Adapter<DogViewHolder>() {

    var data:List<BreedJson> = emptyList()
    val apiService = DogApplication().serviceLocator.apiServiceDog
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        return DogViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.bind(data[position],breedClick)

    }

    override fun getItemCount(): Int {
        return data.size
    }
}

class DogViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),LayoutContainer {

    companion object {
        fun from(parent: ViewGroup): DogViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val layout = layoutInflater.inflate(R.layout.dog_list, parent, false)
            return DogViewHolder(layout)

        }
    }

    fun bind(breed: BreedJson, breedClick: BreedClick)
    {
        val textView = itemView.findViewById(R.id.dogItem) as TextView
        textView.text = breed.title

        containerView.setOnClickListener {
            breedClick.breedClickListener(breed)
        }


    }

}
