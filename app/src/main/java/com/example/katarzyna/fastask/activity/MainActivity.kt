package com.example.katarzyna.fastask.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.katarzyna.fastask.R
import com.example.katarzyna.fastask.activity.alltask.TaskAdapter
import com.example.katarzyna.fastask.activity.alltask.TaskPresenter
import com.example.katarzyna.fastask.activity.alltask.TaskView
import com.example.katarzyna.fastask.base.BaseActivity
import com.example.katarzyna.fastask.model.entity.Task
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :  BaseActivity<TaskPresenter>(), TaskView {
    private val taskAdapter = TaskAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        presenter.loadAllTasks()
        presenter.onViewCreated()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.all_tasks -> {
                presenter.loadAllTasks()
                return@OnNavigationItemSelectedListener true
            }
            R.id.reported -> {
                presenter.loadReported()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun instantiatePresenter(): TaskPresenter {
        return TaskPresenter(this)    }

    override fun updateTask(task: List<Task>) {
        task_recycleview.layoutManager = LinearLayoutManager(this)
        task_recycleview.adapter = taskAdapter
        taskAdapter.updatePosts(task)
        println("update")    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun hideLoading() {
        task_recycleview.visibility = View.VISIBLE
        progres_bar.visibility = View.INVISIBLE
    }

    override fun showLoading() {
        task_recycleview.visibility = View.INVISIBLE
        progres_bar.visibility = View.VISIBLE
    }

}
