package cc.nevsky.education.android

/**
 * Класс данных фильма.
 *
 * @author Aleksandr Vvedenskiy
 * @date 2020.05
 */
//data class FilmsItem(val title: String, val shortDescription: String, val pictureId: Int, val image: String) {
data class FilmsItem(val id: Int, val title: String, val image: String) {

    /**
     * Плюсуем filmCounter. Чтобы имена и описания были разными.
     */
    init {
        MyStorage.filmCounter++
    }
}
