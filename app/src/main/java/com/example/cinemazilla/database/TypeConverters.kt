package com.example.cinemazilla.database

import androidx.room.TypeConverter
import com.example.cinemazilla.model.AgeRating
import com.example.cinemazilla.model.Images
import com.example.cinemazilla.model.ReleaseDate
import com.google.gson.Gson
import org.json.JSONArray



class TypeConverters {

    @TypeConverter
    fun fromAgeRatingToString(list: List<AgeRating>): String = Gson().toJson(list)

    @TypeConverter
    fun fromGsonToAgeRating(item: String): List<AgeRating> {
        val list = mutableListOf<AgeRating>()
        for (i in 0 until JSONArray(item).length()) {
            list.add(Gson().fromJson(JSONArray(item)[i].toString(), AgeRating::class.java))
        }
        return list
    }

    @TypeConverter
    fun fromImagesToString(images: Images): String = Gson().toJson(images)
    @TypeConverter
    fun fromGsonToImages(item: String): Images = Gson().fromJson(item, Images::class.java)

    @TypeConverter
    fun fromReleaseDateToString(releaseDates: List<ReleaseDate>): String = Gson().toJson(releaseDates)
    @TypeConverter
    fun fromGsonToReleaseDates(item: String): List<ReleaseDate> {
        val list = mutableListOf<ReleaseDate>()
        for (i in 0 until JSONArray(item).length()) {
            list.add(Gson().fromJson(JSONArray(item)[i].toString(), ReleaseDate::class.java))
        }
        return list
    }
}