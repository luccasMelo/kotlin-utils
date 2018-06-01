package com.luccasmelo.samplekotlinutil

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.luccasmelo.kotlinutils.clicked
import com.luccasmelo.kotlinutils.log
import com.luccasmelo.kotlinutils.mask
import com.luccasmelo.kotlinutils.showConfirm
import com.luccasmelo.samplekotlinutil.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.main = this
        Log.e("TAG", "12345678912".mask("###.###.###-##"))
        showConfirm("Activity created")
    }

    fun onAdapterClick() {
        "onAdapterClick".log()
        binding.btnAdapter.clicked()
        startActivity(Intent(this, AdapterActivity::class.java))
    }

    fun onMonetaryClick() {
        "onMonetaryClick".log()
        binding.btnMonetary.clicked()
        startActivity(Intent(this, MonetaryActivity::class.java))
    }

    fun onPersistenceClick() {
        "onPersistenceClick".log()
        binding.btnPersistence.clicked()
        startActivity(Intent(this, PersistenceActivity::class.java))
    }

    fun onMaskClick() {
        "onMaskClick".log()
        binding.btnMask.clicked()
        startActivity(Intent(this, MaskActivity::class.java))

    }
}
