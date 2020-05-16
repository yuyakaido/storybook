package com.yuyakaido.android.storybook

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.yuyakaido.android.storybook.databinding.ActivityStorybookBinding

class StorybookActivity : AppCompatActivity() {

    companion object {
        lateinit var storybook: Storybook

        fun createIntent(context: Context): Intent {
            return Intent(context, StorybookActivity::class.java)
        }
    }

    private val binding by lazy { ActivityStorybookBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = GroupAdapter<GroupieViewHolder>()
        adapter.addAll(storybook.elements.map { ListItem(element = it) })
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

}