package cc.nevsky.education.android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cc.nevsky.education.android.exitToInternet.App
import cc.nevsky.education.android.exitToInternet.FilmModel
import cc.nevsky.education.android.exitToInternet.FilmsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Главная Activity.
 *
 * @author Aleksandr Vvedenskiy
 * @date 2020.04
 */
class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MyApp"
    }

    val items = mutableListOf<FilmsItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val adapter = getAdapter()

        list.adapter = FilmsAdapter(LayoutInflater.from(this), items, getOnFilmClickListener())
        App.instance.api.getFilms().enqueue(object : Callback<List<FilmModel>?> {
            override fun onFailure(call: Call<List<FilmModel>?>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<List<FilmModel>?>,
                response: Response<List<FilmModel>?>
            ) {
                items.clear()
                if (response.isSuccessful) {
                    response.body()
                        ?.forEach {
                            items.add(
                                FilmsItem(
                                    it.id,
                                    it.title,
                                    it.image
                                )
                            )
                        }
                }
                if(list.adapter is FilmsAdapter) {
                    (list.adapter as FilmsAdapter).notifyDataSetChanged()
                }
//                (list.adapter as FilmsAdapter).notifyDataSetChanged()
            }
        })
    }

    private fun getOnFilmClickListener() : FilmsAdapter.OnFilmsClickListener {
        return object : FilmsAdapter.OnFilmsClickListener {
            override fun onDetailClick(filmsItem: FilmsItem, position: Int) {
                    // region вызов активити с описанием
                    val intent = Intent(this@MainActivity, NewFolderActivity::class.java)
                    intent.putExtra("title", filmsItem.title)
                    intent.putExtra("shortDescription", filmsItem.title)
//                    intent.putExtra("pictureId", filmsItem.id)
                    intent.putExtra("imageUrl", filmsItem.image)
                    startActivity(intent)
                    // endregion
                }

                override fun onFilmLongClick(filmsItem: FilmsItem) {
                    Log.i(TAG, "onFilmLongClick")
                    MyStorage.favoriteList.add(filmsItem)
                    Toast.makeText(
                        applicationContext,
                        "${filmsItem.title} добавлен в избранное.",
                        Toast.LENGTH_LONG
                    ).show()
                }

                override var usageAs: String = "list"

        }
    }
}