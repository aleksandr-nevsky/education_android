package cc.nevsky.education.android

import cc.nevsky.education.android.utils.CommonUtils

/**
 * Объект для хранения состояния.
 *
 * @author Aleksandr Vvedenskiy
 * @date 2020.04
 */
object MyStorage {
    /**
     * Счётчик дополнительно загруженных страниц.
     */
    var filmCounter = 1

    /**
     * Список избранных фильмов
     */
    val favoriteList: MutableList<FilmsItem> = mutableListOf()

    /**
     * Список всех фильмов
     */
    val listOfFilms = CommonUtils().generateFilmsList()
}