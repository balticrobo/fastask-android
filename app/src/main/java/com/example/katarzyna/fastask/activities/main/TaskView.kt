package com.example.katarzyna.fastask.activities.main

import com.example.katarzyna.fastask.base.BaseView
import com.example.katarzyna.fastask.model.Task

interface TaskView: BaseView {
    fun updateTask(task: List<Task>)

    fun showError(error:String)

    fun hideLoading()

}