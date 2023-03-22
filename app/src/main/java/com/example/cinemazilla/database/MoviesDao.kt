package com.example.cinemazilla.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.cinemazilla.model.Film

@Dao
interface MoviesDao {

    @Query("SELECT * FROM Film WHERE genre = :genre")
    suspend fun getFilmsByGenre(genre: String): List<Film>

    @Insert
    suspend fun insertFilms(films: List<Film>)

    @Query("DELETE FROM Film")
    suspend fun clearTable()

}