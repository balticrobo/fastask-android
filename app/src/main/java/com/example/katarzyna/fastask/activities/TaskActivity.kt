package com.example.katarzyna.fastask.activities

import android.os.Bundle
import com.example.katarzyna.fastask.R
import com.example.katarzyna.fastask.base.BaseActivity
import com.example.katarzyna.fastask.model.Task

class TaskActivity : BaseActivity<TaskPresenter>(), TaskView{
//    private lateinit var binding: ActivityPostBinding
    private val postsAdapter = TaskAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_task)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_task)
//        binding.adapter = postsAdapter
//        binding.layoutManager = LinearLayoutManager(this)
//        binding.dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)

        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }


    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun instantiatePresenter(): TaskPresenter {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateTask(task: List<Task>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}