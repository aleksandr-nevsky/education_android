package cc.nevsky.education.android.goAhead

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import cc.nevsky.education.android.R
import com.otus.otusfragmentsnew.recyclerTwo.NewsAdapter
import com.otus.otusfragmentsnew.recyclerTwo.NewsItem

class NewsListFragment : Fragment() {
    var listener: NewsListListener? = null

    companion object {
        const val TAG = "NewsListFragment"
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

    /**
     * View создана.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.recyclerView).adapter = NewsAdapter(LayoutInflater.from(activity), listOf(
            NewsItem(0, "News 0"),
            NewsItem(1, "News 1"),
            NewsItem(2, "News 2"),
            NewsItem(3, "News 3"),
            NewsItem(4, "News 4")
        )) {
            listener?.onNewsSelect(it)
        }
    }

    interface NewsListListener {
        fun onNewsSelect(newsItem: NewsItem)
    }
}