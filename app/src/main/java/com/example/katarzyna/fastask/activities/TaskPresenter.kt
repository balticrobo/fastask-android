package com.example.katarzyna.fastask.activities

import com.example.katarzyna.fastask.base.BasePresenter
import com.example.katarzyna.fastask.base.BaseView
import com.example.katarzyna.fastask.connection.TaskApi
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class TaskPresenter(postView: TaskView): BasePresenter<TaskView>(postView)  {
    @Inject
    lateinit var postApi: TaskApi

    private var subscription: Disposable? = null

    override fun onViewCreated() {
//        loadPosts()
    }
}