package com.example.cinemazilla.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.cinemazilla.model.Film
import kotlinx.coroutines.flow.Flow

@Dao
interface MoviesDao {

    @Query("SELECT * FROM Film")
    fun getFilms(): Flow<List<Film>>

    @Insert
    suspend fun insertFilms(films: List<Film>)

    @Query("DELETE FROM Film")
    suspend fun clearTable()

}