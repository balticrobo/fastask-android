package com.example.katarzyna.fastask.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.katarzyna.fastask.R
import com.example.katarzyna.fastask.common.SharedPrefManager.Companion.TASK
import com.example.katarzyna.fastask.model.Task

class TaskDetailsActivity :  AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val task = intent.extras.getParcelable<Task>(TASK)
        println(task.comment)
        setContentView(R.layout.activity_task_details)
    }
}
