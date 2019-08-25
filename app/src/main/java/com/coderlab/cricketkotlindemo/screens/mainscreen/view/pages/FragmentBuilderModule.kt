package com.coderlab.cricketkotlindemo.screens.mainscreen.view.pages

import com.coderlab.cricketkotlindemo.screens.mainscreen.view.di.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun bindMainScreenFragment(): MainScreenFragment




}