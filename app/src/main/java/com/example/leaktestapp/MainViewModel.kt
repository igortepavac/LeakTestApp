package com.example.leaktestapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    fun drop(param: String, onDone: suspend (String) -> Unit) {
        Log.e("LeakCanary", "onDrop $this")
        viewModelScope.launch {
            Log.e("LeakCanary", "viewModelScopeLaunch")
            val result = calculate(param)
            onDone(result)
        }
    }

    private suspend fun calculate(param: String): String = withContext(Dispatchers.IO) {
        delay(7000)
        "result for input $param"
    }
}