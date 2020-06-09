package cc.nevsky.education.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_new_folder.*


/**
 * Activity с описанием.
 *
 * @author Aleksandr Vvedenskiy
 * @date 2020.04
 */
class NewFolderActivity : AppCompatActivity() {
    var imageUrl: String? = null
    var descriptionText: String? = null

    /**
     * Отрисовываем в зависимости от передаваемых параметров.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_folder)

//        val pictureId = getIntent().getIntExtra("pictureId", 0)
         imageUrl = getIntent().getStringExtra("imageUrl")
        descriptionText = getIntent().getStringExtra("shortDescription")

//        this.filmView.setImageResource(pictureId)
//        Glide.with(filmView.imageIv.context)
//            .load(imageUrl)
//            .placeholder(R.drawable.ic_image)
//            .error(R.drawable.ic_error)
//            .override(filmView.imageIv.resources.getDimensionPixelSize(R.dimen.image_size))
//            .centerCrop()
//            .into(filmView.imageIv)

        this.description.setText(descriptionText)
    }

    override fun onStart() {
        super.onStart()
        Glide.with(this.applicationContext)
            .load(imageUrl)
            .placeholder(R.drawable.ic_image)
            .error(R.drawable.ic_error)
            .override(this.filmView.resources.getDimensionPixelSize(R.dimen.image_size))
            .centerCrop()
            .into(this.filmView)
    }
}