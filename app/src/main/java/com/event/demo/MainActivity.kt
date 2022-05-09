package com.event.demo

import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.BarUtils
import com.event.demo.banner.BannerAdapter
import com.event.demo.banner.BannerViewModel
import com.event.demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<EventViewModel> { EventViewModelFactory(application) }
    private val bannerViewModel by viewModels<BannerViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //沉浸式状态栏
        BarUtils.setStatusBarColor(this, Color.TRANSPARENT)

        binding.bannerView.adapter = BannerAdapter(bannerViewModel.getBannerData())
        binding.indicatorView.apply {
            setupWithViewPager(binding.bannerView)
        }

        binding.add.clickNoRepeat { addContent() }
        binding.list.clickNoRepeat { EventListActivity.start(this) }
    }

    private fun addContent() {
        val code = binding.inputcode.text.trim().toString()
        if (code.isNotEmpty()) {
            viewModel.update(code.toInt())
            binding.inputcode.setText("")
        }
    }
}