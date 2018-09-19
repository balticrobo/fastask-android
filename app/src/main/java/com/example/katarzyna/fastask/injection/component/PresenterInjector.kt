package com.example.katarzyna.fastask.injection.component

import com.example.katarzyna.fastask.activities.main.TaskPresenter
import com.example.katarzyna.fastask.base.BaseView
import com.example.katarzyna.fastask.injection.module.ContextModule
import com.example.katarzyna.fastask.injection.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton
//
@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {

    fun inject(postPresenter: TaskPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}