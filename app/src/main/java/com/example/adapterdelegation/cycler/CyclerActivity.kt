package com.example.adapterdelegation.cycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.adapterdelegation.R
import com.example.adapterdelegation.data.Item
import com.example.adapterdelegation.data.ItemDataSource
import com.example.adapterdelegation.databinding.ActivityListBinding
import com.squareup.cycler.Recycler
import com.squareup.cycler.toDataSource

class CyclerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupList()
    }

    private fun setupToolbar() {
        supportActionBar?.let {
            it.setTitle(R.string.main_cycler)
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }
    }

    private fun setupList() {
        val recycler = Recycler.adopt<Item>(binding.list) {
            basicRow()
            nestedRow()
            toggleRow()
        }
        recycler.data = ItemDataSource.getItems().toDataSource()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
