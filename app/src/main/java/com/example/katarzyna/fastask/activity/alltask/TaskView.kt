package com.example.katarzyna.fastask.activity.alltask

import com.example.katarzyna.fastask.base.BaseView
import com.example.katarzyna.fastask.model.entity.Task

interface TaskView: BaseView {
    fun updateTask(task: List<Task>)

    fun showError(error:String)

    fun hideLoading()

    fun showLoading()

}