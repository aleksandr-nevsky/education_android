package cc.nevsky.education.android.goAhead

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import cc.nevsky.education.android.R

class NewsDetailedFragment : Fragment(){
    companion object {
        const val TAG = "NewsDetailedFragment"
        const val EXTRA_TITLE = "EXTRA_TITLE"

        fun newInstance(text: String) :NewsDetailedFragment {
            val fragment = NewsDetailedFragment()

            val bundle = Bundle()
            bundle.putString(EXTRA_TITLE, text)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news_detailed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (view as TextView).text = arguments?.getString(EXTRA_TITLE, "default")
    }
}