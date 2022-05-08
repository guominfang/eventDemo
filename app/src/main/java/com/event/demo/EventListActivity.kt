package com.event.demo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.event.demo.databinding.ActivityEventListBinding

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

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityEventListBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}