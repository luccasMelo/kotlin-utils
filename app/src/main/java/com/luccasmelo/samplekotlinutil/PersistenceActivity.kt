package com.luccasmelo.samplekotlinutil

import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.luccasmelo.kotlinutils.load
import com.luccasmelo.kotlinutils.loadString
import com.luccasmelo.kotlinutils.save
import com.luccasmelo.samplekotlinutil.databinding.ActivityPersistenceBinding

public class PersistenceActivity : AppCompatActivity() {
    val informationToSave = ObservableField<String>("")
    val informationSaved = ObservableField<String>("")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityPersistenceBinding = DataBindingUtil.setContentView(this, R.layout.activity_persistence)
        binding.persistence = this
    }

    fun onLoad() {
        informationSaved.set(loadString<String>(this, "sample_string"))
    }

    fun onSave() {
        //use this method only to save string, for object call save(context) without tag param
        informationToSave.get()?.save(this, "sample_string")
    }
}