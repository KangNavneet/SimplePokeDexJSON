package com.navneet.simplepokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_life_cycle_scope.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LifeCycleScope : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle_scope)
        enterData2.setOnClickListener {

            lifecycleScope.launch {

                    enterData2.isEnabled = false
                    showData2.text="Hello Requested"


                withContext(Dispatchers.Default)
                {
                    Thread.sleep(3000)
                }





                    showData2.text="Got Result"
                    enterData2.isEnabled = true

            }




        }
    }
}