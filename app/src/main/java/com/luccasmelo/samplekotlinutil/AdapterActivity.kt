package com.luccasmelo.samplekotlinutil

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.luccasmelo.samplekotlinutil.databinding.ActivityAdapterBinding

public class AdapterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityAdapterBinding = DataBindingUtil.setContentView(this, R.layout.activity_adapter)
        binding.rcv.adapter = AdapterImplement(listOf("item1","item2"))
        binding.rcv.layoutManager = LinearLayoutManager(this)

    }
}