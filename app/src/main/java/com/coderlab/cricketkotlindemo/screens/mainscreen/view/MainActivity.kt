package com.coderlab.cricketkotlindemo.screens.mainscreen.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.coderlab.cricketkotlindemo.R
import com.coderlab.cricketkotlindemo.screens.mainscreen.model.UserData
import com.coderlab.cricketkotlindemo.screens.mainscreen.view.pages.MainScreenFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector
    @Inject
    lateinit var userData: UserData

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("dagger", " UserData > $userData > value ${userData.username}")

        hello_text.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_screen_container, MainScreenFragment(), "MainScreenFragment")
                .commitAllowingStateLoss()
        }

    }
}
