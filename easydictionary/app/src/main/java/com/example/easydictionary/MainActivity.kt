package com.example.easydictionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.easydictionary.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchbtn.setOnClickListener{
            val word= binding.searchbar.text.toString()
        getmeaning(word)
        }
    }
private fun getmeaning(word:String){
    setinprogress(true)
    GlobalScope.launch{
        val response= Retrofitinstance.Dictionaryapi.getmeaning(word)
        runOnUiThread{
            setinprogress(false)
        }
        Log.i("Response form API",response.body().toString())
    }


}
    private fun setui(response:wordresult){
        binding.wordtv.text=response.word
        binding.phonetictv.text=response.phonetic
    }

    private fun setinprogress(inprogress:Boolean){
        if (inprogress){
            binding.searchbtn.visibility=View.GONE
            binding.progressbr.visibility=View.VISIBLE
        }else{
            binding.searchbtn.visibility=View.VISIBLE
            binding.progressbr.visibility=View.GONE
        }

    }
}