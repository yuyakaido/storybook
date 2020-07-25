package com.yuyakaido.android.storybook

import android.view.View
import com.xwray.groupie.Group

class Storybook(
  val title: String,
  val items: List<Item>,
  private val depth: Int = 0
) {
  fun toGroupieItems(): List<Group> {
    return items.map { it.toGroupieItem() }
  }
  fun toNext(section: Item.Section): Storybook {
    return Storybook(
      title = section.title,
      items = section.items,
      depth = depth.inc()
    )
  }
  fun hasHistory(): Boolean {
    return depth > 0
  }
}

sealed class Item {
  abstract val title: String
  abstract fun toGroupieItem(): Group

  class Section(
    override val title: String,
    val items: List<Item>
  ) : Item() {
    override fun toGroupieItem(): Group {
      return SectionItem(this)
    }
  }

  sealed class Element : Item() {
    abstract class Platform(
      override val title: String
    ) : Element() {
      abstract fun view(): View
      override fun toGroupieItem(): Group {
        return PlatformElementItem(this)
      }
    }
    abstract class Groupie(
      override val title: String
    ) : Element() {
      abstract fun group(): Group
      override fun toGroupieItem(): Group {
        return GroupieElementItem(this)
      }
    }
  }
}
