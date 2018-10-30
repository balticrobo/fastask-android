package com.example.katarzyna.fastask.activity

import com.example.katarzyna.fastask.activity.alltask.TaskAdapter
import com.example.katarzyna.fastask.activity.alltask.TaskPresenter
import com.example.katarzyna.fastask.activity.alltask.TaskView
import com.example.katarzyna.fastask.base.BaseFragment
import com.example.katarzyna.fastask.model.entity.Task


//todo change tastpresenter to <T> presenter
class TListBaseFragment  :  BaseFragment<TaskPresenter>(), TaskView//{BaseFragment<TaskPresenter>(), TaskView {
{

    override  lateinit var presenter: TaskPresenter

    private val taskAdapter = TaskAdapter(context) //todo make generic


    override fun instantiatePresenter(): TaskPresenter {
        presenter = TaskPresenter(this)
        return presenter
    }

    override fun updateTask(task: List<Task>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(error: String) {
        println("terrible error")
    }

    override fun hideLoading() {
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
