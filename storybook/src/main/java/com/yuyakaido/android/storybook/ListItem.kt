package com.yuyakaido.android.storybook

import com.xwray.groupie.databinding.BindableItem
import com.yuyakaido.android.storybook.databinding.ItemListBinding

class ListItem(private val element: Element) : BindableItem<ItemListBinding>() {

    override fun getLayout(): Int {
        return R.layout.item_list
    }

    override fun bind(binding: ItemListBinding, position: Int) {
        binding.title.text = element.title
        binding.container.addView(element.view())
    }

}
