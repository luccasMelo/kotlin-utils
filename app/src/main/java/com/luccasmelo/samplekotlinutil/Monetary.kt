package com.luccasmelo.samplekotlinutil

import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.luccasmelo.kotlinutils.moneyToDouble
import com.luccasmelo.kotlinutils.toMoney
import com.luccasmelo.samplekotlinutil.databinding.ActivityMonetaryBinding

public class MonetaryActivity:AppCompatActivity(){

    val value = ObservableField("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding :  ActivityMonetaryBinding =  DataBindingUtil.setContentView(this, R.layout.activity_monetary)
        binding.monetary = this
        Log.e("TAG","hehufhi2.0".replace( "[^0-9]".toRegex(), ""))

    }

    fun onConvert(){
        val  value =  this.value.get()!!
        if(value.contains(',')){//Money
            this.value.set(value.moneyToDouble().toString())
        }else if (value.contains('.')){//Double
            this.value.set((value.toDouble().toMoney()))
        }else{//Plain value
            this.value.set(value.toMoney())
        }

    }


}