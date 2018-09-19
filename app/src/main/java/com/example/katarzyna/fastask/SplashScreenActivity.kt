package com.example.katarzyna.fastask

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.katarzyna.fastask.activities.main.TaskActivity


class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash_screen)

        val intent = Intent(applicationContext,
                TaskActivity::class.java)
        startActivity(intent)
        finish()
    }
}
