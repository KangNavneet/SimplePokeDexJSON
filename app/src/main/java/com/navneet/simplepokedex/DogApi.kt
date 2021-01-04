package com.navneet.simplepokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_dog_api.*
import kotlinx.android.synthetic.main.activity_retrofit.*
import kotlinx.android.synthetic.main.dog_list.*
import kotlinx.coroutines.launch

class DogApi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_api)

        dogRecyclerView.layoutManager= LinearLayoutManager(this)
        var apiServiceDog=DogApplication().serviceLocator.apiServiceDog

        enterData5.setOnClickListener {

            lifecycleScope.launch {
                try {
                    val data= apiServiceDog.getDogs()



                    val adapter=DogRecyclerView(BreedClick {data ->
                        Toast.makeText(applicationContext, data.title, Toast.LENGTH_SHORT).show()
                    } )


                    adapter.data=data.buildBreedJson()
                    dogRecyclerView.adapter=adapter
//                    dogItem.text=dogBreedJsonList.toString()
                   // adapter.breedJson = dogBreedJsonList
                   // adapter.notifyDataSetChanged()
                    //showData5.text=result.message.toString()



                }
                catch (e:Exception)
                {
                    Toast.makeText(this@DogApi,"Failed", Toast.LENGTH_LONG).show()
                }

            }
        }
    }
}