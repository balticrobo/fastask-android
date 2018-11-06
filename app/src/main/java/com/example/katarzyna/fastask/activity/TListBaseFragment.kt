package com.example.katarzyna.fastask.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import com.example.katarzyna.fastask.activity.alltask.TaskAdapter
import com.example.katarzyna.fastask.activity.alltask.TaskPresenter
import com.example.katarzyna.fastask.activity.alltask.TaskView
import com.example.katarzyna.fastask.base.BaseFragment
import com.example.katarzyna.fastask.model.entity.Task
import kotlinx.android.synthetic.main.list_base_activity.*


//todo change tastpresenter to <T> presenter
class TListBaseFragment: BaseFragment<TaskPresenter>(), TaskView {

    private lateinit var  taskAdapter:TaskAdapter

    override fun instantiatePresenter(): TaskPresenter {
        return TaskPresenter(this)
    }

    override fun updateTask(task: List<Task>) {
//        taskAdapter.updatePosts(task)
    }

    override fun showError(error: String) {
        println(error)
    }

    override fun hideLoading() {
        loading_bar.visibility = INVISIBLE
    }

    override fun showLoading() {
        loading_bar.visibility = VISIBLE
    }

    override fun onStart() {
        super.onStart()
        taskAdapter = TaskAdapter(activity!!.applicationContext)
        presenter = instantiatePresenter()
        presenter.loadAllTasks()
    }


}
