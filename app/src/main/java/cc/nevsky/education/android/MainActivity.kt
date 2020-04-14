package cc.nevsky.education.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onNfClick(view: View?) {
        val intent = Intent(this@MainActivity, NewFolderActivity::class.java)
        intent.putExtra("name", 1)
        startActivity(intent)
    }

    fun onNf2Click(view: View?) {
        val intent = Intent(this@MainActivity, NewFolderActivity::class.java)
        intent.putExtra("name", 2)
        startActivity(intent)
    }

    fun onNf3Click(view: View?) {
        val intent = Intent(this@MainActivity, NewFolderActivity::class.java)
        intent.putExtra("name", 3)
        startActivity(intent)
    }
}
