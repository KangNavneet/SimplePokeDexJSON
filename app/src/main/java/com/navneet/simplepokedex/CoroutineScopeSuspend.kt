package com.navneet.simplepokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_coroutine_scope_suspend.*
import kotlinx.android.synthetic.main.activity_life_cycle_scope.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutineScopeSuspend : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_scope_suspend)
        enterData3.setOnClickListener {

            lifecycleScope.launch {

                enterData3.isEnabled = false
                showData3.text="Hello Requested"



                sleep()



                showData3.text="Got Result"
                enterData3.isEnabled = true

            }




        }
    }

   suspend fun sleep()
    {

        withContext(Dispatchers.Default)
        {
            Thread.sleep(3000)
        }

    }

    /*
    Another Way
    suspend fun sleep()=withContext(Dispatchers.Default)
    {
    Thread.sleep(3000)

    }




     */

}