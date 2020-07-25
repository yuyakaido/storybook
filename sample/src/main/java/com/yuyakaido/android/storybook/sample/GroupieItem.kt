package com.yuyakaido.android.storybook.sample

import android.widget.Toast
import com.xwray.groupie.databinding.BindableItem
import com.yuyakaido.android.storybook.sample.databinding.ItemGroupieBinding

class GroupieItem(
  private val name: String
) : BindableItem<ItemGroupieBinding>() {

  override fun getLayout(): Int {
    return R.layout.item_groupie
  }

  override fun bind(binding: ItemGroupieBinding, position: Int) {
    binding.button.text = name
    binding.button.setOnClickListener {
      Toast.makeText(binding.root.context, name, Toast.LENGTH_SHORT).show()
    }
  }

}