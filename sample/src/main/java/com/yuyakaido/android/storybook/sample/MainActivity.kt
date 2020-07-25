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
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    startActivity(
      StorybookActivity.createIntent(
        applicationContext,
        Storybook(
          name = "Storybook",
          items = List(4) { sectionIndex ->
            Item.Section(
              name = "Section: $sectionIndex",
              items = List(4) { subSectionIndex ->
                val subSectionId = Random(subSectionIndex).nextInt()
                val randomForSubSubSection = Random(subSectionId)
                Item.Section(
                  name = "SubSection: $subSectionId",
                  items = List(4) {
                    Item.Section(
                      name = "SubSubSection: ${randomForSubSubSection.nextInt()}",
                      items = List(4) { elementIndex ->
                        if (elementIndex.rem(2) == 0) {
                          object : Item.Element.Platform(name = "PlatformElement: $elementIndex") {
                            override fun view(): View {
                              return Button(this@MainActivity).apply {
                                val name = "Button: $elementIndex"
                                text = name
                                setOnClickListener {
                                  Toast.makeText(context, name, Toast.LENGTH_SHORT).show()
                                }
                              }
                            }
                          }
                        } else {
                          object : Item.Element.Groupie(name = "GroupieElement: $elementIndex") {
                            override fun group(): Group {
                              return GroupieItem(name = "Button: $elementIndex")
                            }
                          }
                        }
                      }
                    )
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
