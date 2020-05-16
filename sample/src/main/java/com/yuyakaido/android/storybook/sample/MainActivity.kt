package com.yuyakaido.android.storybook.sample

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.yuyakaido.android.storybook.Element
import com.yuyakaido.android.storybook.Storybook
import com.yuyakaido.android.storybook.StorybookActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val context = this
        StorybookActivity.storybook = Storybook(
            elements = List(10) {
                object : Element(title = "Title $it") {
                    override fun view(): View = Button(context).apply { text = "Button $it" }
                }
            }
        )
        startActivity(StorybookActivity.createIntent(this))
        finish()
    }

}
