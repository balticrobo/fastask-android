package com.example.katarzyna.fastask.activity

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.katarzyna.fastask.R
import com.example.katarzyna.fastask.common.Keys.Companion.TASK
import com.example.katarzyna.fastask.common.SharedPrefManager
import com.example.katarzyna.fastask.connection.TaskApi
import com.example.katarzyna.fastask.model.dto.TaskDto
import com.example.katarzyna.fastask.model.entity.Task
import kotlinx.android.synthetic.main.activity_task_details.*
import javax.inject.Inject

class TaskDetailsActivity :  AppCompatActivity() {

    @Inject
    lateinit var postApi: TaskApi

    private lateinit var task: Task

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_details)
        task = intent.extras.getParcelable<Task>(TASK)
        setTaskInfo(task)
        setButton()

    }

    private fun setButton() {
        assign_to_me.setOnClickListener {
            val myId = SharedPrefManager().getId(this)
            val taskDto = TaskDto(task.id, false, myId)
            postApi.reserveTast(taskDto)
        }
    }

    private fun setTaskInfo(task: Task?) {
        task?.let {
            action.text = task.action
            comment.text = task.comment
            location.text = task.location
        }
    }
}
