package com.example.quotegen

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import com.example.quotegen.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var relativeLayout: RelativeLayout


    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        relativeLayout=binding.Relativelayout
        val switch=binding.switch1

        getquote()
        binding.nextbtn.setOnClickListener{
            getquote()
        }

        switch.setOnCheckedChangeListener{_,isChecked->
            changebackgorundcolor(isChecked)
        }
    }

    private fun changebackgorundcolor(isdark:Boolean) {
        val backgroundColor=if (isdark)R.color.black else R.color.white
        relativeLayout.setBackgroundResource(backgroundColor)
    }

    private fun getquote(){
setinprogress(true)
        GlobalScope.launch {
            try {
               val response= retrofit_instance.quoteApi.getRandomQuote()
                runOnUiThread(){
                    setinprogress(false)
                    response.body()?.first()?.let {
                        setui(it)
                    }
                }
                }catch (e:Exception){
                    runOnUiThread{
                        setinprogress(false)
                        Toast.makeText(applicationContext,"fuck your wifi",Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }
    private fun setui(quote:quotemodel){
        binding.quoteTv.text=quote.q
        binding.authertv.text=quote.a
    }
    private fun setinprogress(inProgress:Boolean){
        if (inProgress){
            binding.progressbr.visibility=View.VISIBLE
            binding.nextbtn.visibility=View.GONE
        }else{
            binding.progressbr.visibility=View.GONE
            binding.nextbtn.visibility=View.VISIBLE
        }
    }



}