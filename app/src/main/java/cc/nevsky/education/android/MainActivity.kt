package cc.nevsky.education.android

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("MY", "onCreate");
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.colorizeFilmLabel()
    }

    fun onNfClick(view: View?) {
        val intent = Intent(this@MainActivity, NewFolderActivity::class.java)
        intent.putExtra("name", 1)
        MyStorage.filmId = 1
        colorizeFilmLabel()
        startActivity(intent)
    }

    fun onNf2Click(view: View?) {
        val intent = Intent(this@MainActivity, NewFolderActivity::class.java)
        intent.putExtra("name", 2)
        MyStorage.filmId = 2
        colorizeFilmLabel()

        startActivity(intent)
    }

    fun onNf3Click(view: View?) {
        val intent = Intent(this@MainActivity, NewFolderActivity::class.java)
        intent.putExtra("name", 3)
        MyStorage.filmId = 3
        colorizeFilmLabel()

        startActivity(intent)
    }

    private fun colorizeFilmLabel() {
        Log.i("MY", "Storage.filmId = " + MyStorage.filmId);
        this.textView.setTextColor(Color.BLACK)
        this.textView2.setTextColor(Color.BLACK)
        this.textView3.setTextColor(Color.BLACK)
        when (MyStorage.filmId) {
            1 -> this.textView.setTextColor(Color.BLUE)
            2 -> this.textView2.setTextColor(Color.BLUE)
            3 -> this.textView3.setTextColor(Color.BLUE)
        }
    }
}
