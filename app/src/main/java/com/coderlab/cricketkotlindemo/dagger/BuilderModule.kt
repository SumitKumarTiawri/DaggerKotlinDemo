package com.coderlab.cricketkotlindemo.dagger

import com.coderlab.cricketkotlindemo.screens.mainscreen.view.MainActivity
import com.coderlab.cricketkotlindemo.screens.mainscreen.view.di.ActivityModule
import com.coderlab.cricketkotlindemo.screens.mainscreen.view.di.ActivityScope
import com.coderlab.cricketkotlindemo.screens.mainscreen.view.pages.FragmentBuilderModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class BuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    abstract fun bindFeatureActivity(): MainActivity

}