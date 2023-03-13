package com.banana.reader.analyze

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class JsonUtils {
    fun parseByGson(data: String): List<String> {
        val gson = Gson()
        val typeOf = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(data, typeOf)
    }
}