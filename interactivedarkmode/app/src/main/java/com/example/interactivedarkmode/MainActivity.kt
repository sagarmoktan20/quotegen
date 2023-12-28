package com.example.interactivedarkmode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Switch

class MainActivity : AppCompatActivity() {
    private lateinit var linearLayout:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttondark = findViewById<Button>(R.id.buttondark)
       // val buttonlight = findViewById<Button>(R.id.buttonlight)
         linearLayout = findViewById<LinearLayout>(R.id.linearlayout)
        val switch=findViewById<Switch>(R.id.switch1)

        buttondark.setOnClickListener {
            //turn the screen dark
            linearLayout.setBackgroundResource(R.color.readingmode)
        }

//        buttonlight.setOnClickListener{
//            linearLayout.setBackgroundResource(R.color.white)
//        }

        switch.setOnCheckedChangeListener{_,isChecked->
            updatebackgroundcolor(isChecked)
        }



    }

    private fun updatebackgroundcolor(isDarkMode: Boolean) {
        var backgroundColor = if (isDarkMode) R.color.readingmode else R.color.white

        linearLayout.setBackgroundResource(backgroundColor)
    }
}

