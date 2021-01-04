 package com.navneet.simplepokedex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

 class MainActivity : AppCompatActivity() {

     private val coroutineScope=CoroutineScope(Dispatchers.Default)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enterData.setOnClickListener {

            coroutineScope.launch {
                withContext(Dispatchers.Main)
                {
                    enterData.isEnabled = false
                    pokeData.text="Hello Requested"
                }

                  Thread.sleep(3000)



                withContext(Dispatchers.Main)
                {
                    pokeData.text="Got Result"
                    enterData.isEnabled = true
                }
            }




        }

        coroutineScopeActivity.setOnClickListener {
            val intent = Intent(this, CoroutineScopeActivity::class.java).apply {

            }
            startActivity(intent)
        }

        lifecycleActivity.setOnClickListener {
            val intent = Intent(this, LifeCycleScope::class.java).apply {

            }
            startActivity(intent)
        }

        coroutineScopeWithFun.setOnClickListener {
            val intent = Intent(this, CoroutineScopeSuspend::class.java).apply {

            }
            startActivity(intent)
        }


        retrofitActivity.setOnClickListener {
            val intent = Intent(this, RetrofitActivity::class.java).apply {

            }
            startActivity(intent)
        }


        dogApiActivity.setOnClickListener {
            val intent = Intent(this, DogApi::class.java).apply {

            }
            startActivity(intent)
        }
    }
}