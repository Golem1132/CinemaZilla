package com.example.cinemazilla.repository

import com.example.cinemazilla.database.MoviesDao
import com.example.cinemazilla.model.Film
import javax.inject.Inject

class DbRepository @Inject constructor(private val moviesDao: MoviesDao) {

    fun getFilms() = moviesDao.getFilms()
    suspend fun insertFilms(films: List<Film>) = moviesDao.insertFilms(films)
}