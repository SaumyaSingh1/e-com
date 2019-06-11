package com.saumya.app.Activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.saumya.app.R

class MainActivity : AppCompatActivity() {


    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {

                Log.e("TAG" , "Inside MainActivity")
                startActivity(Intent(baseContext , NavigationActivity::class.java))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_deals -> {
               startActivity(Intent(baseContext , DealsActivity::class.java))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_Account -> {
                startActivity(Intent(baseContext , DealsActivity::class.java))
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_bottom)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}
