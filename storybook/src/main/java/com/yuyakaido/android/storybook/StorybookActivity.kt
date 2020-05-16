package com.yuyakaido.android.storybook

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class StorybookActivity : AppCompatActivity() {

    companion object {
        lateinit var storybook: Storybook

        fun createIntent(context: Context): Intent {
            return Intent(context, StorybookActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storybook)
        val container = findViewById<LinearLayout>(R.id.container)
        storybook.elements.forEach {
            container.addView(it.invoke())
        }
    }

}