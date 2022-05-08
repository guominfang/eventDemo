package com.event.demo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.event.demo.databinding.ActivityEventListBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * @author gmf
 * @description
 * @date 2022/5/8.
 */
class EventListActivity : AppCompatActivity() {

    lateinit var binding: ActivityEventListBinding

    private val viewModel by viewModels<EventViewModel> { EventViewModelFactory(application) }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, EventListActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //沉浸式状态栏

        //沉浸式状态栏
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener { onBackPressed() }

        val adapter = EventAdapter()
        binding.recyclerView.adapter = adapter

        lifecycleScope.launch {
            viewModel.allEventList.collectLatest { adapter.submitData(it) }
        }
    }
}