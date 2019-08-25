package com.coderlab.cricketkotlindemo.dagger

import com.coderlab.cricketkotlindemo.BaseApplication
import dagger.Module
import dagger.Provides

@Module
class ContextModule {

    @Provides
    @ApplicationScope
    @ApplicationContext
    fun provideApplicationContext(application: BaseApplication) = application.applicationContext


}