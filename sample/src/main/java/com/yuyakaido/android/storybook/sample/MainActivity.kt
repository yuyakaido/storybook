package com.yuyakaido.android.storybook.sample

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.yuyakaido.android.storybook.Storybook
import com.yuyakaido.android.storybook.StorybookActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        StorybookActivity.storybook = Storybook(
            elements = listOf(
                { Button(this).apply { text = "Button 1" } },
                { Button(this).apply { text = "Button 2" } },
                { Button(this).apply { text = "Button 3" } },
                { Button(this).apply { text = "Button 4" } }
            )
        )
        startActivity(StorybookActivity.createIntent(this))
        finish()
    }

}
