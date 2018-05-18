package com.luccasmelo.kotlinutils

import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*


public fun String.toMoney(): String {
    val locale = Locale.getDefault()
    return this.toMoney(locale)
}

public fun String.toMoney(locale: Locale): String {
    val numberFormat = NumberFormat.getCurrencyInstance(locale)
    if (this == ("0")) {
        val bigDecimal = BigDecimal(this).setScale(2, BigDecimal.ROUND_HALF_UP)
        return numberFormat.format(bigDecimal)
    }
    return numberFormat.format(java.lang.Double.valueOf(this) / 100)
}


public fun Double.toMoney(): String {
    val locale = Locale.getDefault()
    return this.toMoney(locale)
}

public fun Double.toMoney(locale: Locale): String {
    val numberFormat = NumberFormat.getCurrencyInstance(locale)
    if (this == (0.0)) {
        val bigDecimal = BigDecimal(this).setScale(2, BigDecimal.ROUND_HALF_UP)
        return numberFormat.format(bigDecimal)
    }
    return numberFormat.format(this)
}


public fun String.formatDouble(): Double {
    if (this == ("0")) {
        return 0.0
    }
    return java.lang.Double.valueOf(this) / 100
}


public fun String.moneyToDouble(): Double {
    return  this.replace( "[^0-9]".toRegex(), "").formatDouble()
}

