package com.example.androidbase.presentation.extensions

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody
import org.json.JSONObject


fun Any.toJson(): String {
    val gson = Gson()
    return gson.toJson(this)
}

inline fun <reified T> String.fromJson(): T {
    val gson = Gson()
    val type = object : TypeToken<T>() {}.type
    return gson.fromJson(this, type)
}

inline fun <reified T> ResponseBody.getErrorObject(): T {
    val gson = Gson()
    val jsonObject = JSONObject(charStream().readText())
    return gson.fromJson(jsonObject.toString(), T::class.java)
}


