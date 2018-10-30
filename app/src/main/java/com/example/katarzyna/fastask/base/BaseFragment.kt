package com.example.katarzyna.fastask.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.katarzyna.fastask.R

abstract class BaseFragment<P : BasePresenter<BaseView>> : BaseView, Fragment() {
    protected open lateinit var presenter: P


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        presenter = instantiatePresenter()
        return inflater.inflate(R.layout.list_base_activity, container, false)
    }


    protected abstract fun instantiatePresenter(): P

    override fun getContext(): Context {
        return super.getContext()!!
    }

}