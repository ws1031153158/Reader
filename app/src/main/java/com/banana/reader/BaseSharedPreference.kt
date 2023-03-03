package com.banana.reader

import android.content.Context
import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class BaseSharedPreference<T> (private val name: String, private val defaultValue: T) : ReadWriteProperty<Any?, T> {

    private val mSharedPreferences: SharedPreferences by lazy {
        Application.getInstance().getSharedPreferences(name, Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return getSharedPreferences(name, defaultValue)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putSharedPreferences(name, value)
    }

    private fun <T> getSharedPreferences(key: String, default: T): T = with(mSharedPreferences) {
        val res = when(default) {
            is Long -> getLong(name, default)
            is String -> getString(name, default)
            is Int -> getInt(name, default)
            is Boolean -> getBoolean(name, default)
            is Float -> getFloat(name, default)
            else -> throw IllegalArgumentException("find preference failed")
        }
        res as T
    }

    private fun <U> putSharedPreferences(key: String, value: U) = with(mSharedPreferences.edit()) {
        when(value) {
            is Long -> putLong(name, value)
            is String -> putString(name, value)
            is Int -> putInt(name, value)
            is Boolean -> putBoolean(name, value)
            is Float -> putFloat(name, value)
            else -> throw IllegalArgumentException("save preference failed")
        }.apply()
    }
}
