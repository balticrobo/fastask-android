package com.example.katarzyna.fastask.activity.alltask

import com.example.katarzyna.fastask.base.BasePresenter
import com.example.katarzyna.fastask.connection.TaskApi
import com.example.katarzyna.fastask.model.entity.Task
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TaskPresenter(postView: TaskView): BasePresenter<TaskView>(postView) {
    @Inject
    lateinit var postApi: TaskApi

    private var subscription: Disposable? = null


    fun loadAllTasks() {
        changeSubscriber{ postApi.getAllActiveTask()}
    }

    fun loadReported(){
        changeSubscriber{ postApi.getCreatedByMeTask()}
    }

    private fun changeSubscriber(funtion:()-> Observable<List<Task>>){
        view.showLoading()
        subscription = setSubscribe(funtion())
    }

    private fun setSubscribe(requestedList: Observable<List<Task>>): Disposable? {
        return requestedList
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate {}
                .subscribe(
                        {

                            postList ->
                                view.hideLoading()
                                view.updateTask(postList)
                        },
                        {   error ->
                            view.hideLoading()
                            view.showError("error") }
                )
    }

    fun loadReserved() {
        //TODO think about that
    }
}
