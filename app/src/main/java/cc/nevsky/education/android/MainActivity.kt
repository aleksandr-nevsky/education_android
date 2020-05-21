package cc.nevsky.education.android

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.BounceInterpolator
import android.view.animation.LinearInterpolator
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


/**
 * Главная Activity.
 *
 * @author Aleksandr Vvedenskiy
 * @date 2020.04
 */
class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        doValueAnimations()
//        doObjectAnimator()
//        animatorSet()
//        animatorXml()
//        viewPropertyAnimations()
        layoutAnimation()
    }

    private fun layoutAnimation() {
        redSquare.setOnClickListener {
            purpleSquare.visibility = View.GONE
        }
    }

    private fun viewPropertyAnimations() {
        purpleSquare.animate()
            .alpha(0.1f)
            .translationX(500f)
            .translationY(500f)
            .setDuration(2000)
            .start()
    }

    private fun animatorXml() {
        AnimatorInflater.loadAnimator(this, R.animator.animator).apply {
            setTarget(purpleSquare)
            start()
        }
    }

    private fun animatorSet() {
        val translateXAnim = ObjectAnimator.ofFloat(purpleSquare, "translationX", 0f, 500f).apply {
            duration = 2000
            interpolator = BounceInterpolator()
//            repeatCount = ValueAnimator.INFINITE
//            repeatMode = ValueAnimator.REVERSE

        }

        val alphaAnim = ObjectAnimator.ofFloat(purpleSquare, "alpha", 0.1f).apply {
            duration = 2000
            interpolator = LinearInterpolator()
//            repeatCount = ValueAnimator.INFINITE
//            repeatMode = ValueAnimator.REVERSE

        }

        AnimatorSet().apply {
//            play(translateXAnim)
            play(alphaAnim).after(translateXAnim)
            start()
        }

    }

    private fun doObjectAnimator() {
        ObjectAnimator.ofFloat(purpleSquare, "translationX", 0f, 500f).apply {
            duration = 2000
            interpolator = BounceInterpolator()
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE

            start()
        }
    }

    private fun doValueAnimations() {
        ValueAnimator.ofFloat(0f, 500f).apply {
            duration = 2000
            interpolator = OvershootInterpolator()
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
            addUpdateListener {
                val value = it.animatedValue as Float
                findViewById<View>(R.id.purpleSquare).translationX = value
                findViewById<View>(R.id.purpleSquare).translationY = value

            }
            start()
        }
    }
}