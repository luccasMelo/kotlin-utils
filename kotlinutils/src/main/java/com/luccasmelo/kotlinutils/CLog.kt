package com.luccasmelo.kotlinutils

import android.util.Log

public fun Any.log(){
    Log.w("TAG", this.toString())
}

public fun Any.logE(){
    Log.e("TAG", this.toString())
}

public fun Any.logD(){

    Log.d("TAG", this.toString())
}

