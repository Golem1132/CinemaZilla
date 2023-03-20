package com.example.cinemazilla.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cinemazilla.data.Movie

@Database(
    entities = [
        Movie::class
               ],
    version = 1,
    exportSchema = true,
    autoMigrations = []
)
abstract class CinemaZillaDb: RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
}