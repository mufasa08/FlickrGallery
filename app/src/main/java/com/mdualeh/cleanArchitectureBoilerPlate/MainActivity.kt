package com.mdualeh.cleanArchitectureBoilerPlate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mdualeh.navigation.features.AppMainNavigation

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startMainNavigation()
    }

    private fun startMainNavigation() = AppMainNavigation.dynamicStart?.let { startActivity(it) }
}
