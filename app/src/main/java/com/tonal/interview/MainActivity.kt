package com.tonal.interview

import android.content.ContentValues.TAG
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.tonal.interview.adapter.MainRecyclerViewAdapter
import com.tonal.interview.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainActivityViewModel
    private lateinit var mainAdapter: MainRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        mainViewModel = MainActivityViewModel(DependencyInjection.movementRepository)
        mainAdapter = MainRecyclerViewAdapter()
        val list = mainViewModel.movementList.value
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            list?.stream()!!.forEach { element -> Log.d(TAG, "onCreate: " + element.id) }
    }
}