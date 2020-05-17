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

class FilmsListFragment : Fragment() {
    var listener: FilmsListListener? = null

    companion object {
        const val TAG = "FilmsListFragment"
    }

    /**
     * Создание View.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView $this")

        return inflater.inflate(R.layout.fragment_films_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.recyclerView).adapter = FilmsAdapter(LayoutInflater.from(activity), MyStorage.listOfFilms,
        object : FilmsAdapter.OnFilmsClickListener{
            override fun onDetailClick(filmsItem: FilmsItem, position: Int) {
                listener?.onDetailClick(filmsItem)
            }

            override fun onFilmLongClick(filmsItem: FilmsItem) {
                listener?.onAddToFavoriteClick(filmsItem)
            }

            override var usageAs: String = "list"
        })
    }

    interface FilmsListListener {
        fun onDetailClick(filmsItem: FilmsItem)
        fun onAddToFavoriteClick(filmsItem: FilmsItem)
    }
}
