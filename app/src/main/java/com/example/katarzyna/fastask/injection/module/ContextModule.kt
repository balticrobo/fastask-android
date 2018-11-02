package com.example.katarzyna.fastask.injection.module

import android.app.Application
import android.content.Context
import com.example.katarzyna.fastask.base.BaseView
import dagger.Module
import dagger.Provides

@Module
@Suppress("unused")
object ContextModule {
    
    @Provides
    @JvmStatic
    internal fun provideApplication(context: Context): Application {
        return context.applicationContext as Application
    }
}