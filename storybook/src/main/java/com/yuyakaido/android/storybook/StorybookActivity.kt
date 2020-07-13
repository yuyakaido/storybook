package com.yuyakaido.android.storybook

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.yuyakaido.android.storybook.databinding.ActivityStorybookBinding

class StorybookActivity : AppCompatActivity() {

  companion object {
    private lateinit var storybook: Storybook

    fun createIntent(context: Context, storybook: Storybook): Intent {
      this.storybook = storybook
      return Intent(context, StorybookActivity::class.java)
    }
  }

  private val binding by lazy { ActivityStorybookBinding.inflate(layoutInflater) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)

    title = storybook.title
    if (storybook.hasHistory()) {
      supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    val adapter = GroupAdapter<GroupieViewHolder>()
    adapter.addAll(storybook.toGroupieItems())
    adapter.setOnItemClickListener { item, _ ->
      when (item) {
        is SectionItem -> {
          startActivity(createIntent(this, storybook.toNext(item.section)))
        }
        is ElementItem -> {
          Toast.makeText(this, "Element", Toast.LENGTH_SHORT).show()
        }
      }
    }
    binding.recyclerView.layoutManager = LinearLayoutManager(this)
    binding.recyclerView.adapter = adapter
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      android.R.id.home -> finish()
    }
    return super.onOptionsItemSelected(item)
  }

}