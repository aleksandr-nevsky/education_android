package cc.nevsky.education.android.utils

import cc.nevsky.education.android.FilmsItem
import cc.nevsky.education.android.MyStorage
import cc.nevsky.education.android.R

/**
 * Вспомогательные утилиты.
 *
 * @author Aleksandr Vvedenskiy
 * @date 2020.04
 */
class CommonUtils {

    /**
     * Генерируем список фильмов для отображения.
     */
    fun generateFilmsList(): MutableList<FilmsItem> {
        val mutableListOf: MutableList<FilmsItem> = mutableListOf(
            FilmsItem("Новая папка ${MyStorage.filmCounter}", "Описание фильма ${MyStorage.filmCounter}", R.drawable.new_folder),
            FilmsItem("Новая папка ${MyStorage.filmCounter}", "Описание фильма ${MyStorage.filmCounter}", R.drawable.new_folder_2),
            FilmsItem("Новая папка ${MyStorage.filmCounter}", "Описание фильма ${MyStorage.filmCounter}", R.drawable.new_folder_3),
            FilmsItem("Новая папка ${MyStorage.filmCounter}", "Описание фильма ${MyStorage.filmCounter}", R.drawable.new_folder_4),
            FilmsItem("Новая папка ${MyStorage.filmCounter}", "Описание фильма ${MyStorage.filmCounter}", R.drawable.new_folder_5),
            FilmsItem("Новая папка ${MyStorage.filmCounter}", "Описание фильма ${MyStorage.filmCounter}", R.drawable.new_folder_6),
            FilmsItem("Новая папка ${MyStorage.filmCounter}", "Описание фильма ${MyStorage.filmCounter}", R.drawable.new_folder_7),
            FilmsItem("Новая папка ${MyStorage.filmCounter}", "Описание фильма ${MyStorage.filmCounter}", R.drawable.new_folder_8),
            FilmsItem("Новая папка ${MyStorage.filmCounter}", "Описание фильма ${MyStorage.filmCounter}", R.drawable.new_folder_9)
        )

        return mutableListOf
    }
}