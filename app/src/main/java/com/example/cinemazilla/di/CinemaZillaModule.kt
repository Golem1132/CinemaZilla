package com.example.cinemazilla.di

import android.content.Context
import androidx.room.Room
import com.example.cinemazilla.database.CinemaZillaDb
import com.example.cinemazilla.database.MoviesDao
import com.example.cinemazilla.repository.DbRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CinemaZillaModule {

    @Provides
    @Singleton
    fun provideMoviesDao(cinemaZillaDb: CinemaZillaDb): MoviesDao = cinemaZillaDb.moviesDao()

    @Provides
    @Singleton
    fun provideDbRepository(moviesDao: MoviesDao): DbRepository = DbRepository(moviesDao)

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): CinemaZillaDb =
        Room.databaseBuilder(
            context,
            CinemaZillaDb::class.java,
            "cinemazilla"
        ).fallbackToDestructiveMigration()
            .build()
}