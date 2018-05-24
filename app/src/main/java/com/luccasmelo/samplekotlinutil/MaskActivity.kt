package com.luccasmelo.samplekotlinutil

import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.luccasmelo.kotlinutils.mask
import com.luccasmelo.samplekotlinutil.databinding.ActivityMaskBinding

public class MaskActivity: AppCompatActivity() {

    val valueMasked = ObservableField("")
    val valueUnMasked = ObservableField("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMaskBinding = DataBindingUtil.setContentView(this,R.layout.activity_mask)
        binding.mask = this
    }

    fun maskPressed(){
        valueMasked.set(valueUnMasked.get()!!.mask("###.###.###-##"))
    }
}