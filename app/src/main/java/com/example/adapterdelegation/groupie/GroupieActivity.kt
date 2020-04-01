package com.example.adapterdelegation.groupie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.adapterdelegation.R
import com.example.adapterdelegation.data.ItemDataSource
import com.example.adapterdelegation.databinding.ActivityListBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder

class GroupieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding

    private lateinit var adapter: GroupAdapter<GroupieViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupList()
    }

    private fun setupToolbar() {
        supportActionBar?.let {
            it.setTitle(R.string.main_groupie)
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }
    }

    private fun setupList() {
        adapter = GroupAdapter()
        binding.list.adapter = adapter
        adapter.addAll(ViewHolderMapper.map(ItemDataSource.getItems()))
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
