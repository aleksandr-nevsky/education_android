package cc.nevsky.education.android

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
//    val listOfFilms = CommonUtils().generateFilmsList()
    val listOfFilms: MutableList<FilmsItem> = mutableListOf()
}