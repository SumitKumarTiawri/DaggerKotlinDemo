package com.coderlab.cricketkotlindemo.screens.mainscreen.view.di

import com.coderlab.cricketkotlindemo.BaseApplication
import com.coderlab.cricketkotlindemo.screens.mainscreen.model.UserData
import com.coderlab.cricketkotlindemo.screens.mainscreen.view.pages.FragmentBuilderModule
import com.coderlab.cricketkotlindemo.screens.mainscreen.viewmodel.factory.MainScreenViewModelFactory
import dagger.Module
import dagger.Provides


@Module(includes = [FragmentBuilderModule::class])
class ActivityModule {
    @Provides
    @ActivityScope
    fun provideUserData() = UserData("hello")

    @Provides
    @ActivityScope
    fun provideMainScreenViewModelFactory(application: BaseApplication): MainScreenViewModelFactory =
        MainScreenViewModelFactory(application = application)

}