package com.coderlab.cricketkotlindemo.screens.mainscreen.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.coderlab.cricketkotlindemo.R
import com.coderlab.cricketkotlindemo.screens.mainscreen.model.UserData
import com.coderlab.cricketkotlindemo.screens.mainscreen.view.pages.MainScreenFragment
import com.coderlab.cricketkotlindemo.screens.mainscreen.viewmodel.MainScreenViewModel
import com.coderlab.cricketkotlindemo.screens.mainscreen.viewmodel.factory.MainScreenViewModelFactory
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var viewModelFactory: MainScreenViewModelFactory

    lateinit var viewModel: MainScreenViewModel

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector
    @Inject
    lateinit var userData: UserData

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainScreenViewModel::class.java)
        viewModel.listOfItems.observe(this, object : Observer<String> {
            override fun onChanged(t: String?) {
                Log.e("viewModel", " MainActivity > $t")
            }
        })
        viewModel.addSomeValue("Add activity value")

        setContentView(R.layout.activity_main)
        Log.e("dagger", " UserData > $userData > value ${userData.username}")

        hello_text.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_screen_container, MainScreenFragment(), "MainScreenFragment")
                .commitAllowingStateLoss()
        }

    }
}
