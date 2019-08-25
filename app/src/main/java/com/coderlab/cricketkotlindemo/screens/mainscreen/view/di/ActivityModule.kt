package com.coderlab.cricketkotlindemo.screens.mainscreen.view.di

import com.coderlab.cricketkotlindemo.screens.mainscreen.model.UserData
import com.coderlab.cricketkotlindemo.screens.mainscreen.view.pages.FragmentBuilderModule
import dagger.Module
import dagger.Provides


@Module(includes = [FragmentBuilderModule::class])
class ActivityModule {
    @Provides
    @ActivityScope
    fun provideUserData() = UserData("hello")
}