package com.example.katarzyna.fastask.common

import android.content.Context

class SharedPrefManager {
    fun getId(context: Context):Int{
        val sharedPreferences= context.getSharedPreferences("pref", 0)
        return sharedPreferences.getInt("id", 0)
    }

}