package com.luccasmelo.kotlinutils

import android.content.Context
import com.google.gson.Gson
import kotlin.reflect.KClass


public fun <T : Any> Any.load(context: Context, type: KClass<T>): T {
    val prefs = context.getSharedPreferences("javaClass.canonicalName", Context.MODE_PRIVATE)
    val simpleName = type.java.simpleName
    val json = prefs.getString(simpleName, "{}")
    return Gson().fromJson<T>(json, type.java)
}


public fun <T : Any> Any.load(context: Context, type: KClass<T>, tag: String): T {
    val prefs = context.getSharedPreferences("javaClass.canonicalName", Context.MODE_PRIVATE)
    val json = prefs.getString(tag, "{}")
    return Gson().fromJson<T>(json, type.java)
}

public fun <T : Any> Any.loadString(context: Context, tag: String): String {
    val prefs = context.getSharedPreferences("javaClass.canonicalName", Context.MODE_PRIVATE)
    return prefs.getString(tag, "")
}

public fun String.save(context: Context, tag: String) {
    val prefsEditor = context.getSharedPreferences("javaClass.canonicalName", Context.MODE_PRIVATE).edit()
    prefsEditor.putString(tag, this)
    prefsEditor.apply()
}

public fun Any.save(context: Context) {
    val prefsEditor = context.getSharedPreferences("javaClass.canonicalName", Context.MODE_PRIVATE).edit()
    val json = Gson().toJson(this)
    val simpleName = this::class.java.simpleName
    prefsEditor.putString(simpleName, json)
    prefsEditor.apply()
}



