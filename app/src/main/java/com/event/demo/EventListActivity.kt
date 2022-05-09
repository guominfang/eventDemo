package com.event.demo

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.blankj.utilcode.util.BarUtils
import com.event.demo.databinding.ActivityEventListBinding
import com.google.android.material.appbar.AppBarLayout
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
        BarUtils.setStatusBarColor(this, Color.TRANSPARENT)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener { onBackPressed() }

        binding.appbarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            internal var scrollRange = -1

            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0 || verticalOffset <= -410) {
                    binding.collapsingToolbarLayout.title = " "
                } else  {
                    binding.collapsingToolbarLayout.title = "UPCOMING EVENTS"
                }
                Log.e("onOffsetChanged", "onOffsetChanged: " + scrollRange +  ", " + verticalOffset)
            }
        })

        val adapter = EventAdapter()
        binding.recyclerView.adapter = adapter

        lifecycleScope.launch {
            viewModel.allEventList.collectLatest { adapter.submitData(it) }
        }


    }
}