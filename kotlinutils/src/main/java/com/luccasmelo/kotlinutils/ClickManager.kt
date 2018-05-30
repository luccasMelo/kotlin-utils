package com.luccasmelo.kotlinutils

import android.os.Handler
import android.view.View

public fun View.setOnClickPrevent(callbackClick: View.OnClickListener) {
    this.setOnClickPrevent(callbackClick, 1000)

}

public fun View.setOnClickPrevent(callbackClick: View.OnClickListener, timeOut: Long) {
    this.setOnClickListener {
        this.clicked(timeOut)
        callbackClick.onClick(this)
    }
}


public fun View.clicked() {
    clicked(1000)
}

public fun View.clicked(timeOut: Long) {

    this.isEnabled = false
    Handler(android.os.Looper.getMainLooper()).postDelayed({
        this.isEnabled = true
    }, timeOut)
}

