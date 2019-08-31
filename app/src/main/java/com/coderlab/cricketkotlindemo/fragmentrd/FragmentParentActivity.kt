package com.coderlab.cricketkotlindemo.fragmentrd

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.coderlab.cricketkotlindemo.R


class FragmentParentActivity : AppCompatActivity() {

    val editText: EditText by lazy {
        findViewById<EditText>(R.id.edit)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, ProductListFragment.newInstance(editText.text.toString()), "ProductListFragment")
                .addToBackStack("ProductListFragment")
                .commit()
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LandingFragment())
                //.addToBackStack("LandingFragment")
                .disallowAddToBackStack()
                .commit()
        }
    }

    override fun onBackPressed() {
        val topFragment: Fragment? = supportFragmentManager.findFragmentById(R.id.container)
        if (!(topFragment is BaseFragment && !topFragment.onBackPressed())) {
            super.onBackPressed()
        }

    }

}