package com.example.katarzyna.fastask.activity

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.katarzyna.fastask.R
import com.example.katarzyna.fastask.activity.alltask.TaskAdapter
import com.example.katarzyna.fastask.activity.alltask.TaskPresenter
import com.example.katarzyna.fastask.activity.alltask.TaskView
import com.example.katarzyna.fastask.base.BaseFragment
import com.example.katarzyna.fastask.model.entity.Task


//todo change tastpresenter to <T> presenter
class TListBaseFragment: BaseFragment<TaskPresenter>(), TaskView {
    override fun instantiatePresenter(): TaskPresenter {
        return TaskPresenter(this)
    }


    lateinit var  taskAdapter:TaskAdapter


    override fun updateTask(task: List<Task>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        taskAdapter = TaskAdapter(activity!!.applicationContext)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

}
