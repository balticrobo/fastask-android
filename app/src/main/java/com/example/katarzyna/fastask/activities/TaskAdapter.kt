package com.example.katarzyna.fastask.activities


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.katarzyna.fastask.model.Task

class TaskAdapter (private val context: Context) : RecyclerView.Adapter<TaskAdapter.PostViewHolder>() {
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private var posts: List<Task> = listOf()

//    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PostViewHolder {
//        val layoutInflater = LayoutInflater.from(context)
//        val binding: ItemPostBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_post, parent, false)
//        return PostViewHolder(binding)
//    }

    override fun getItemCount(): Int {
        return posts.size
    }
    fun updatePosts(posts: List<Task>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    class PostViewHolder(view: View, var context: Context) : RecyclerView.ViewHolder(view) {
        fun bind(task: Task) {

        }
    }
}