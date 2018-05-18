package com.luccasmelo.samplekotlinutil

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.luccasmelo.samplekotlinutil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.main = this

    }

    fun onAdapterClick(){

    }

    fun onMonetaryClick(){
        startActivity(Intent(this,MonetaryActivity::class.java))
    }

    fun onPersistenceClick(){
        startActivity(Intent(this,PersistenceActivity::class.java))
    }
}
