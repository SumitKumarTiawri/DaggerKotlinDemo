package com.coderlab.cricketkotlindemo.datasharing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coderlab.cricketkotlindemo.R
import kotlinx.android.synthetic.main.activity_data_sharing.*

class DataSharingActivity : AppCompatActivity() {

    var categoryId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_sharing)
        fragment_launcher.setOnClickListener {
            val fragment = DataSharingHomeFragment()
            fragment.arguments = Bundle().also { it.putInt("key", ++categoryId) }
            supportFragmentManager.beginTransaction().add(R.id.home_container, fragment, "DataSharingHomeFragment")
                .addToBackStack("DataSharingHomeFragment").commit()
        }
    }


}