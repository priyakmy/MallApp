package com.appsinvo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.appsinvo.adapter.CategoryAdapter
import com.appsinvo.databinding.ActivityMainBinding
import com.appsinvo.utils.DataHolder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setData()
    }

    private fun setData() {
        binding.rvCategory.adapter = CategoryAdapter().apply {
        submitList(DataHolder.categories)
        }
    }
}