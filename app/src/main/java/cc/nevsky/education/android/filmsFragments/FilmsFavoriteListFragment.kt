package cc.nevsky.education.android.filmsFragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import cc.nevsky.education.android.FilmsAdapter
import cc.nevsky.education.android.FilmsItem
import cc.nevsky.education.android.MyStorage
import cc.nevsky.education.android.R

/**
 * Fragment списка избранного.
 *
 * @author Aleksandr Vvedenskiy
 * @date 2020.05
 */
class FilmsFavoriteListFragment : Fragment() {
    var listener: FilmsFavoriteListListener? = null

    companion object {
        const val TAG = "FilmsFavoriteListFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_films_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<RecyclerView>(R.id.recyclerView).adapter =
            FilmsAdapter(LayoutInflater.from(activity), MyStorage.favoriteList,
                object : FilmsAdapter.OnFilmsClickListener {
                    override fun onDetailClick(filmsItem: FilmsItem, position: Int) {
                        Log.i(TAG, "onDetailClick")
                        listener?.onDeleteClick(filmsItem, position)
                    }

                    override fun onFilmLongClick(filmsItem: FilmsItem) {
                        // Только для списка
                    }

                    override var usageAs: String = "favorite"
                })
    }

    interface FilmsFavoriteListListener {
        /**
         * Удаление из списка.
         */
        fun onDeleteClick(filmsItem: FilmsItem, position: Int)
    }
}