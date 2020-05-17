package cc.nevsky.education.android.filmsFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import cc.nevsky.education.android.FilmsItem
import cc.nevsky.education.android.R

/**
 * Фрагмент описания фильма.
 *
 * @author Aleksandr Vvedenskiy
 * @date 2020.05
 */
class FilmsDetailedFragment : Fragment() {
    companion object {
        const val TAG = "FilmsDetailedFragment"
        private const val TITLE = "TITLE"
        private const val SHORT_DESCRIPTION = "SHORT_DESCRIPTION"
        private const val PICTURE_ID = "PICTURE_ID"

        //        fun newInstance(
//            title: String,
//            shortDescription: String,
//            pictureId: Int
//        ): FilmsDetailedFragment {
        fun newInstance(filmsItem: FilmsItem): FilmsDetailedFragment {
            val fragment = FilmsDetailedFragment()

            val bundle = Bundle()
            bundle.putString(TITLE, filmsItem.title)
            bundle.putString(SHORT_DESCRIPTION, filmsItem.shortDescription)
            bundle.putInt(PICTURE_ID, filmsItem.pictureId)

            fragment.arguments = bundle
            return fragment

        }
    }

    /**
     * Создание View.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_films_detailed, container, false)
    }

    /**
     * View создана.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        (view as TextView).text = arguments?.getString(TITLE, "default")
        val description = arguments?.getString(TITLE, "default")
        val pictureId = arguments?.getInt(PICTURE_ID, 0)

        description?.let { view.findViewById<TextView>(R.id.description).text = it }
        pictureId?.let { view.findViewById<ImageView>(R.id.filmView).setImageResource(it) }

    }

}