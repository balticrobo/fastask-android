package com.example.katarzyna.fastask.base

import com.example.katarzyna.fastask.activities.main.TaskPresenter
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

    /**
     * This method may be called when the presenter view is created
     */
    open fun onViewCreated(){}

    /**
     * This method may be called when the presenter view is destroyed
     */
    open fun onViewDestroyed(){}

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is TaskPresenter -> injector.inject(this)
        }
    }
}