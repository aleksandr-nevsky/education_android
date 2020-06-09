package cc.nevsky.education.android.exitToInternet

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("films")
    fun getFilms(): Call<List<FilmModel>>
}