package com.event.demo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.event.demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<EventViewModel> { EventViewModelFactory(application) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addButton.clickNoRepeat { addContent() }
        binding.searchButton.clickNoRepeat { EventListActivity.start(this) }
    }

    private fun addContent() {
        val newContent = binding.inputText.text.trim()
        if (newContent.isNotEmpty()) {
            viewModel.insert(newContent)
            binding.inputText.setText("")
        }
    }
}