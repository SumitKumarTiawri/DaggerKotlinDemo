package com.coderlab.cricketkotlindemo.dagger

import com.coderlab.cricketkotlindemo.BaseApplication
import com.coderlab.cricketkotlindemo.screens.mainscreen.view.MainActivity
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@ApplicationScope
@Component(modules = [AndroidInjectionModule::class, AndroidSupportInjectionModule::class, PreferenceModule::class, ContextModule::class, BuilderModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BaseApplication): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: BaseApplication)


}