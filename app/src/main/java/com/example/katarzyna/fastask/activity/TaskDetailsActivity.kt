package com.example.katarzyna.fastask.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.katarzyna.fastask.R
import com.example.katarzyna.fastask.common.SharedPrefManager.Companion.TASK
import com.example.katarzyna.fastask.model.Task
import kotlinx.android.synthetic.main.activity_task_details.*

class TaskDetailsActivity :  AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //todo white board
        // todo problem with xml
        setContentView(R.layout.activity_task_details)
        val task = intent.extras.getParcelable<Task>(TASK)
        setTaskInfo(task)

    }

    private fun setTaskInfo(task: Task?) {
        task?.let {
            action.text = task.action
            label_comment.text = task.comment
            location.text = task.location
        }
    }
}
