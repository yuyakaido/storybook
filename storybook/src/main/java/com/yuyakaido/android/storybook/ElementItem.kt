package com.yuyakaido.android.storybook

import com.xwray.groupie.databinding.BindableItem
import com.yuyakaido.android.storybook.databinding.ItemElementBinding

class ElementItem(
  private val element: Item.Element
) : BindableItem<ItemElementBinding>() {

  override fun getLayout(): Int {
    return R.layout.item_element
  }

  override fun bind(binding: ItemElementBinding, position: Int) {
    binding.title.text = element.title
    binding.container.addView(element.view())
  }

}
