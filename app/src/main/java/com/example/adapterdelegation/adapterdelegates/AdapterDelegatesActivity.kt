package com.example.adapterdelegation.adapterdelegates

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.adapterdelegation.R
import com.example.adapterdelegation.data.ItemDataSource
import com.example.adapterdelegation.databinding.ActivityListBinding
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class AdapterDelegatesActivity : AppCompatActivity() {

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
            it.setTitle(R.string.main_adapter_delegates)
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }
    }

    private fun setupList() {
        binding.list.adapter = ListDelegationAdapter(
            basicAdapterDelegate(),
            nestedAdapterDelegate(),
            toggleAdapterDelegate()
        ).apply {
            items = ItemDataSource.getItems()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
