package cc.nevsky.education.android

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cc.nevsky.education.android.filmsFragments.FilmsDetailedFragment
import cc.nevsky.education.android.filmsFragments.FilmsFavoriteListFragment
import cc.nevsky.education.android.filmsFragments.FilmsListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar


/**
 * Главная Activity.
 *
 * @author Aleksandr Vvedenskiy
 * @date 2020.04
 */
class MainActivity_old : AppCompatActivity(), FilmsListFragment.FilmsListListener,
    FilmsFavoriteListFragment.FilmsFavoriteListListener {
    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragments()
        initBottomNavigation()
    }

    /**
     * Инициализация BottomNavigation
     */
    private fun initBottomNavigation() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            Log.i(TAG, "OnNavigationItemSelectedListener")
            when (item.itemId) {
                R.id.films -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.fragmentContainer,
                            FilmsListFragment().apply { listener = this@MainActivity_old },
                            FilmsListFragment.TAG
                        )
                        .commit()
                    true
                }
                R.id.favorite -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.fragmentContainer,
                            FilmsFavoriteListFragment().apply { listener = this@MainActivity_old },
                            FilmsFavoriteListFragment.TAG
                        )
                        .addToBackStack(null)
                        .commit()
                    true
                }
                else -> false
            }
        }
    }

    /**
     * Инициализация фрагментов.
     */
    private fun initFragments() {
        val filmsListFragment = FilmsListFragment()
        filmsListFragment.listener = this

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, filmsListFragment, FilmsListFragment.TAG)
            .commit()
    }

    /**
     * Обновляем отображение списка избранных после удаления фильма.
     */
    private fun refreshFavoriteList() {
        supportFragmentManager.findFragmentByTag(FilmsFavoriteListFragment.TAG)?.let {
            supportFragmentManager
                .beginTransaction()
                .detach(it)
                .attach(it)
                .commit()
        }
    }

    private fun openFilmDetailedFragment(filmsItem: FilmsItem) {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.fragmentContainer,
                FilmsDetailedFragment.newInstance(filmsItem),
                FilmsDetailedFragment.TAG
            )
            .addToBackStack(null) // Возврат к предыдущему фрагменту
            .commit()
    }


    override fun onDetailClick(filmsItem: FilmsItem, position: Int) {
        openFilmDetailedFragment(filmsItem)
    }

    override fun onAddToFavoriteClick(filmsItem: FilmsItem) {
        MyStorage.favoriteList.add(filmsItem)
        Toast.makeText(
            applicationContext,
            "${filmsItem.title} добавлен в избранное.",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onDeleteClick(filmsItem: FilmsItem, position: Int) {
        Log.i(TAG, "onDeleteClick")
        val isRemoved = MyStorage.favoriteList.remove(filmsItem)
        Log.i(TAG, "is removed = $isRemoved")

        // Вот тут я не понял правильно ли я делаю?
        refreshFavoriteList()

        Snackbar.make(findViewById(R.id.fragmentContainer), "Фильм удалён", Snackbar.LENGTH_LONG)
            .setAnchorView(findViewById<BottomNavigationView>(R.id.bottomNavigationView))
            .setAction("Отмена") {
                MyStorage.favoriteList.add(filmsItem)
                refreshFavoriteList()
            }
            .show()
    }
}