package com.example.katarzyna.fastask.activities.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.katarzyna.fastask.R
import com.example.katarzyna.fastask.base.BaseActivity
import com.example.katarzyna.fastask.model.Task
import kotlinx.android.synthetic.main.activity_task.*

class TaskActivity : BaseActivity<TaskPresenter>(), TaskView {
//    private lateinit var binding: ActivityPostBinding
    private val postsAdapter = TaskAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun hideLoading() {
        println("hide")
    }

    override fun instantiatePresenter(): TaskPresenter {
        return TaskPresenter(this)
    }

    override fun updateTask(task: List<Task>) {
        task_recycleview.layoutManager = LinearLayoutManager(this)
        task_recycleview.adapter = postsAdapter
        postsAdapter.updatePosts(task)
        println("update")
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }
}