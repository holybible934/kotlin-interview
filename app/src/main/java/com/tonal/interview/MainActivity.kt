package com.tonal.interview

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.tonal.interview.adapter.MainRecyclerViewAdapter
import com.tonal.interview.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainActivityViewModel
    private lateinit var mainAdapter: MainRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        mainViewModel = MainActivityViewModel(DependencyInjection.movementRepository)
        mainViewModel.loadMovementList()
        mainAdapter = MainRecyclerViewAdapter()
        mainViewModel.movementList.observe(this, {
            it.forEach { movement -> Log.w(TAG, "Test:" + movement.id) }
        })
    }
}