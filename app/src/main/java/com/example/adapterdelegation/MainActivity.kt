package com.example.adapterdelegation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.adapterdelegation.adapterdelegates.AdapterDelegatesActivity
import com.example.adapterdelegation.cycler.CyclerActivity
import com.example.adapterdelegation.databinding.ActivityMainBinding
import com.example.adapterdelegation.groupie.GroupieActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnGroupie.setOnClickListener { openActivity(GroupieActivity::class.java) }
            btnAdapterDelegates.setOnClickListener { openActivity(AdapterDelegatesActivity::class.java) }
            btnCycler.setOnClickListener { openActivity(CyclerActivity::class.java) }
        }
    }

    private fun openActivity(clazz: Class<*>) {
        val intent = Intent(this, clazz)
        startActivity(intent)
    }
}
