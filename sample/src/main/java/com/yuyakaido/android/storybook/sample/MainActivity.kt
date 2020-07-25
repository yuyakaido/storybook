package com.yuyakaido.android.storybook.sample

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.xwray.groupie.Group
import com.yuyakaido.android.storybook.Item
import com.yuyakaido.android.storybook.Storybook
import com.yuyakaido.android.storybook.StorybookActivity

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    startActivity(
      StorybookActivity.createIntent(
        this,
        Storybook(
          title = "Storybook",
          items = List(4) { sectionIndex ->
            Item.Section(
              title = "Section: $sectionIndex",
              items = List(4) { subSectionIndex ->
                Item.Section(
                  title = "SubSection: $subSectionIndex",
                  items = List(1024) { elementIndex ->
                    if (elementIndex.rem(2) == 0) {
                      object : Item.Element.Platform(title = "PlatformElement: $elementIndex") {
                        override fun view(): View {
                          return Button(this@MainActivity).apply {
                            val title = "Button: $elementIndex"
                            text = title
                            setOnClickListener {
                              Toast.makeText(context, title, Toast.LENGTH_SHORT).show()
                            }
                          }
                        }
                      }
                    } else {
                      object : Item.Element.Groupie(title = "GroupieElement: $elementIndex") {
                        override fun group(): Group {
                          return GroupieItem(title = "Button: $elementIndex")
                        }
                      }
                    }
                  }
                )
              }
            )
          }
        )
      )
    )
  }

}
