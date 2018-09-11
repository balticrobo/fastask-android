package com.example.katarzyna.fastask

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.Window
import java.lang.Thread.sleep
import android.view.WindowManager
import android.view.Window.FEATURE_NO_TITLE




class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash_screen)
        val timer = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(6500)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    startActivity(Intent(application, MainActivity::class.java))
                    this@SplashScreenActivity.finish()
                }
            }
        }
        timer.start()

        val intent = Intent(applicationContext,
                MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
