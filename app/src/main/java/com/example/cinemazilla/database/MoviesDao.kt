package com.example.cinemazilla.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import com.example.cinemazilla.data.Movie

@Dao
interface MoviesDao {

    @Query("SELECT * FROM Movie WHERE genre = :genre")
    suspend fun getMoviesByGenre(genre: String): List<Movie>

    @Query("DELETE FROM Movie")
    suspend fun clearTable()

}