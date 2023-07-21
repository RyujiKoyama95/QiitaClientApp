package com.example.qootaclient.data

import androidx.room.TypeConverter
import com.google.gson.Gson

class Converters {
    val gson = Gson()

    @TypeConverter
    fun fromUser(user: Article.User): String {
        return gson.toJson(user)
    }

    @TypeConverter
    fun toUser(json: String): Article.User {
        return gson.fromJson(json, Article.User::class.java)
    }
}