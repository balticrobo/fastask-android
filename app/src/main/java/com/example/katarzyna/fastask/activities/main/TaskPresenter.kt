package com.example.katarzyna.fastask.activities.main

import com.example.katarzyna.fastask.base.BasePresenter
import com.example.katarzyna.fastask.connection.TaskApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TaskPresenter(postView: TaskView): BasePresenter<TaskView>(postView)  {
    @Inject
    lateinit var postApi: TaskApi

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        loadPosts()
    }

    fun loadPosts() {
        subscription = postApi
                .getAllActiveTask()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate { view.hideLoading() }
                .subscribe(
                        { postList -> view.updateTask(postList) },
                        { view.showError("error") }
                )
    }
}