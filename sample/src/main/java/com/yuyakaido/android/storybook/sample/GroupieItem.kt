package com.yuyakaido.android.storybook.sample

import android.widget.Toast
import com.xwray.groupie.databinding.BindableItem
import com.yuyakaido.android.storybook.sample.databinding.ItemGroupieBinding

class GroupieItem(
  private val title: String
) : BindableItem<ItemGroupieBinding>() {

  override fun getLayout(): Int {
    return R.layout.item_groupie
  }

  override fun bind(binding: ItemGroupieBinding, position: Int) {
    binding.button.text = title
    binding.button.setOnClickListener {
      Toast.makeText(binding.root.context, title, Toast.LENGTH_SHORT).show()
    }
  }

}