package com.example.katarzyna.fastask.activity.alltask


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.katarzyna.fastask.R
import com.example.katarzyna.fastask.model.Task
import kotlinx.android.synthetic.main.item_task.view.*

class TaskAdapter (private val context: Context) : RecyclerView.Adapter<TaskAdapter.PostViewHolder>() {
    private var posts: List<Task> = listOf()

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_task, parent, false)
        return PostViewHolder(v, context)
    }

    override fun getItemCount(): Int {
        return posts.size
    }
    fun updatePosts(posts: List<Task>) {
        this.posts = posts
        notifyDataSetChanged()
        println(itemCount)
    }

    class PostViewHolder(var view: View, var context: Context) : RecyclerView.ViewHolder(view) {
        fun bind(task: Task) {
            view.task_name.text = task.action
        }
    }
}