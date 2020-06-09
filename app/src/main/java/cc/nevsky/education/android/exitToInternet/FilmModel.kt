package cc.nevsky.education.android.exitToInternet

import com.google.gson.annotations.SerializedName

data class FilmModel(

    @SerializedName("poster_path") val image: String,
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String
)