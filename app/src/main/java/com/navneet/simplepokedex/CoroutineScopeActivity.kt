package com.navneet.simplepokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_coroutine_scope.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.enterData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutineScopeActivity : AppCompatActivity() {
    private val coroutineScope= CoroutineScope(Dispatchers.Default)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_scope)

        enterData1.setOnClickListener {

            coroutineScope.launch {
                withContext(Dispatchers.Main)
                {
                    enterData1.isEnabled = false
                    showData1.text="Hello Requested"
                }

                Thread.sleep(3000)



                withContext(Dispatchers.Main)
                {
                    showData1.text="Got Result"
                    enterData1.isEnabled = true
                }
            }




        }
    }
}