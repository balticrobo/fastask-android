package com.example.katarzyna.fastask.activities

import com.example.katarzyna.fastask.R
import com.example.katarzyna.fastask.base.BasePresenter
import com.example.katarzyna.fastask.base.BaseView
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
     //   view.showLoading()
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