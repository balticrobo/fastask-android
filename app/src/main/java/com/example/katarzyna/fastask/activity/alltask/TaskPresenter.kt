package com.example.katarzyna.fastask.activity.alltask

import com.example.katarzyna.fastask.base.BasePresenter
import com.example.katarzyna.fastask.connection.TaskApi
import com.example.katarzyna.fastask.model.Task
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TaskPresenter(postView: TaskView): BasePresenter<TaskView>(postView) {
    @Inject
    lateinit var postApi: TaskApi

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        loadAllTasks()
    }

    fun loadAllTasks() {
        subscription = setSubscribe(postApi.getCreatedByMeTask())
    }

    fun setSubscribe(requestedList: Observable<List<Task>>): Disposable? {
        return requestedList
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate { view.hideLoading() }
                .subscribe(
                        { postList -> view.updateTask(postList) },
                        { view.showError("error") }
                )
    }

    fun loadMyRegisteredTasks() {
        subscription = setSubscribe(postApi.getCreatedByMeTask())
    }
}
