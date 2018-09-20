package com.example.katarzyna.fastask.base

import com.example.katarzyna.fastask.activity.alltask.TaskPresenter
import com.example.katarzyna.fastask.injection.component.DaggerPresenterInjector
import com.example.katarzyna.fastask.injection.component.PresenterInjector
import com.example.katarzyna.fastask.injection.module.ContextModule
import com.example.katarzyna.fastask.injection.module.NetworkModule

abstract class BasePresenter<out V : BaseView>(protected val view: V) {
    private val injector: PresenterInjector = DaggerPresenterInjector
            .builder()
            .baseView(view)
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    open fun onViewCreated(){}

    open fun onViewDestroyed(){}

    private fun inject() {
        when (this) {
            is TaskPresenter -> injector.inject(this)
        }
    }
}