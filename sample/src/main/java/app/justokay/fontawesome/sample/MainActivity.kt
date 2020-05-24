package app.justokay.fontawesome.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.justokay.fontawesome.AwesomeFontFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = AwesomeFontFactory.getFont(this, "android")

//        preview.setImageDrawable(FontAwesomeDrawable(model))

        GlideApp.with(this)
            .load(model)
            .into(preview)

    }
}
