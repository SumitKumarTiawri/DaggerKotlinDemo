package com.coderlab.cricketkotlindemo

import android.app.Activity
import android.app.Application
import android.app.Service

import androidx.fragment.app.Fragment
import com.coderlab.cricketkotlindemo.dagger.DaggerApplicationComponent

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasServiceInjector
import dagger.android.support.DaggerFragment
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


class BaseApplication : Application(), HasActivityInjector, HasSupportFragmentInjector,
    HasServiceInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var serviceInjector: DispatchingAndroidInjector<Service>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

    override fun serviceInjector(): AndroidInjector<Service> = serviceInjector

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun onCreate() {
        super.onCreate()
        val component = DaggerApplicationComponent.builder().application(this).build()
        component.inject(this)
    }
}