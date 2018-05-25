package com.luccasmelo.samplekotlinutil

import android.databinding.ObservableField
import com.luccasmelo.kotlinutils.GenericAdapter

public class AdapterImplement(val listString: List<String>): GenericAdapter<List<ObservableField<String>>>(){
    override fun getVarId(): Int {
        return BR.item
    }

    override fun getItemCount(): Int {
        return listString.size
    }

    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.item_adapter
    }

    override fun getObjForPosition(position: Int): Any {
        return ObservableField(listString[position])
    }

    override fun update(objects: List<List<ObservableField<String>>>) {
        //implement
    }

}