package com.example.qootaclient.data

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase

@Dao
interface ArticleDao {
    @Query("SELECT * FROM article")
    suspend fun getArticles(): List<Article>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(articles: List<Article>)
}

@Database(entities = [Article::class], version = 1, exportSchema = false)
abstract class ArticleDatabase: RoomDatabase() {
    abstract fun dao(): ArticleDao

    companion object {
        private var INSTANCE: ArticleDatabase? = null

        fun getDatabase(context: Context): ArticleDatabase {
            INSTANCE ?: synchronized(this) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    ArticleDatabase::class.java,
                    "article_database"
                ).fallbackToDestructiveMigration().build()
            }
            return INSTANCE as ArticleDatabase
        }
    }
}