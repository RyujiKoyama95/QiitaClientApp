package com.example.qootaclient.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article")
data class Article(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val url: String,
    val title: String,
    val user: User
) {
    data class User(
        val userId: String,
        @ColumnInfo(name = "profile_image_url") val profileImageUrl: String
    )
}