package cc.nevsky.education.android

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Список избранного.
 *
 * @author Aleksandr Vvedenskiy
 * @date 2020.05
 */
class FavoriteListActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MyApp"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_list)

        initRecycler()
    }

    /**
     * Инициализация recycler.
     */
    private fun initRecycler() {
        val recycler = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler.layoutManager = layoutManager
        recycler.adapter = FilmsAdapter(
            LayoutInflater.from(this), MyStorage.favoriteList,
            object : FilmsAdapter.OnFilmsClickListener {
                override fun onDetailClick(filmsItem: FilmsItem, position: Int) {
                    Log.i(TAG, "position = $position")
                    Log.i(TAG, "MyStorage.favoriteList.size = " + MyStorage.favoriteList.size)
                    MyStorage.favoriteList.removeAt(position - 1) // 1 header
                    recycler.adapter?.notifyItemRemoved(position)
                }

                override fun onFilmLongClick(filmsItem: FilmsItem) {
                    // Только для главного списка.
                }

                override var usageAs: String = "favorite"
            })
    }
}