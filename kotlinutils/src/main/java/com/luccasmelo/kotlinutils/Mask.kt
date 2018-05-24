package com.luccasmelo.kotlinutils

import android.databinding.adapters.TextViewBindingAdapter
import android.widget.EditText
import android.text.Editable
import android.text.TextWatcher
import android.util.Log


class MaskWatcher(private val mask: String) : TextWatcher {
    private var isRunning = false
    private var isDeleting = false

    override fun beforeTextChanged(charSequence: CharSequence, start: Int, count: Int, after: Int) {
        isDeleting = count > after
    }

    override fun onTextChanged(charSequence: CharSequence, start: Int, before: Int, count: Int) {}

    override fun afterTextChanged(editable: Editable) {
        if (isRunning || isDeleting) {
            return
        }
        isRunning = true

        val editableLength = editable.length
        if (editableLength < mask.length) {
            if (mask[editableLength] != '#') {
                editable.append(mask[editableLength])
            } else if (mask[editableLength - 1] != '#') {
                editable.insert(editableLength - 1, mask, editableLength - 1, editableLength)
            }
        }

        isRunning = false
    }


}

public fun String.unmask(): String {
    return this.replace("[^0-9]*".toRegex(), "")
}

public fun String.mask(mask: String): String {
    val stringAppendable = StringBuilder()

    var i:Int = 0
    mask.toCharArray().forEachIndexed { index, value ->
        if (index < this.length) {
            if (value == '#') {
                stringAppendable.append(this[i])
                i++
            }else {
                stringAppendable.append(value)
            }
        }
    }


    return stringAppendable.toString()
}
