package com.luccasmelo.kotlinutils

import android.graphics.Color
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView

public fun AppCompatActivity.showConfirm(message: String) {
    this.showSnack(message, getString(com.luccasmelo.kotlinutils.R.string.green))
}

public fun View.showConfirm(message: String) {
    this.showSnack(message, context.getString(com.luccasmelo.kotlinutils.R.string.green))

}

public fun AppCompatActivity.showError(message: String) {
    this.showSnack(message, getString(com.luccasmelo.kotlinutils.R.string.red))

}

public fun View.showError(message: String) {
    this.showSnack(message, context.getString(com.luccasmelo.kotlinutils.R.string.red))

}

public fun AppCompatActivity.showWarning(message: String) {
    this.showSnack(message, getString(com.luccasmelo.kotlinutils.R.string.yellow))

}

public fun View.showWarning(message: String) {
    this.showSnack(message, context.getString(com.luccasmelo.kotlinutils.R.string.yellow))

}

public fun View.showSnack(message: String, color: String) {
    val snack = Snackbar.make(this.findViewById(R.id.container), message, Snackbar.LENGTH_LONG)
    val view = snack.view
    val tv: TextView = view.findViewById(android.support.design.R.id.snackbar_text);
    tv.setTextColor(Color.parseColor("#FFF"))
    view.setBackgroundColor(Color.parseColor(color))
    snack.show()
}

public fun AppCompatActivity.showSnack(message: String, color: String) {
    val snack = Snackbar.make(this.findViewById(R.id.container), message, Snackbar.LENGTH_LONG)
    val view = snack.view
    val tv: TextView = view.findViewById(android.support.design.R.id.snackbar_text)
    tv.setTextColor(Color.parseColor("#FFF"))
    view.setBackgroundColor(Color.parseColor(color))
    snack.show()
}


public fun AppCompatActivity.showSnackUndo(message: String, color: String, function: () -> (Unit)) {
    val snack = Snackbar.make(this.findViewById(R.id.container), message, Snackbar.LENGTH_LONG)
    val view = snack.view
    val tv: TextView = view.findViewById(android.support.design.R.id.snackbar_text)
    tv.setTextColor(Color.parseColor("#FFF"))
    view.setBackgroundColor(Color.parseColor(color))
    snack.setAction(R.string.undo,{
        function.invoke()
    })
    snack.show()
}
