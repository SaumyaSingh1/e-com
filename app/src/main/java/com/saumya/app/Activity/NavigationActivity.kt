package com.saumya.app.Activity

import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.inputmethodservice.KeyboardView
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.GravityCompat
import android.view.MenuItem
import android.support.v4.widget.DrawerLayout
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.ShareActionProvider
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.saumya.app.Fragments.FashionFrag
import com.saumya.app.R
import com.saumya.app.Viewpager.FragmentB
import com.saumya.app.Viewpager.Fragmenta
import com.saumya.app.Viewpager.Fragmentc
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_navigation.*
import java.util.*

@Suppress("CAST_NEVER_SUCCEEDS")
class NavigationActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {

                Log.e("TAG", "Inside MainActivity")
                startActivity(Intent(baseContext, NavigationActivity::class.java))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_deals -> {
                startActivity(Intent(baseContext, DealsActivity::class.java))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_Account -> {
                startActivity(Intent(baseContext, MyAccount::class.java))
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
    private var strin: String = ""
    private var currentPage: Int = 0
    private var shareActionProvider: ShareActionProvider? = null
    private var NUM_PAGES: Int = 0
    private var swipeTimer = Timer()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        Log.e("TAG", "Inside Oncreate  of NavigationActivity")
        val view=View(baseContext)
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        val fragmentList = arrayListOf<Fragment>()
        fragmentList.add(Fragmenta())
        fragmentList.add(FragmentB())
        fragmentList.add(Fragmentc())
        val pagerAdapter = com.saumya.app.Viewpager.PagerAdapter(fragmentList, supportFragmentManager)
        viewpager.adapter = pagerAdapter
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        navView.setNavigationItemSelectedListener(this)
        val handler = Handler()
        val Update = Runnable {
            if (currentPage === NUM_PAGES) {
                currentPage = 0
            }
            viewpager.setCurrentItem(currentPage++, true)
        }
        swipeTimer = Timer()
        swipeTimer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(Update)
            }
        }, 500, 3000)

        navmenu.setOnClickListener {

            if (!drawer_layout.isDrawerOpen(GravityCompat.START))
                drawer_layout.openDrawer(Gravity.START)
            else
                drawer_layout.closeDrawer(Gravity.END)

        }

        nav_bottom.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        searchicon.setOnClickListener {
            //set visibilty of search bar to true

//            editsearch.visibility = View.VISIBLE
            Toast.makeText(baseContext, "Item Not Available", Toast.LENGTH_SHORT).show()
        }
        strin = editsearch.text.toString()
        btnshowall.setOnClickListener {
            startActivity(Intent(baseContext, ShowallActivity::class.java))
        }
        a.setOnClickListener {
            Log.e("TAG", "Huttay frag code started")
            val fragment = FashionFrag()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frag, fragment)
            transaction.commit()
        }
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navigation, menu)

        menu.findItem(R.id.nav_share).also { menuItem ->
            shareActionProvider = menuItem.actionProvider as? ShareActionProvider
        }
        return true
    }

    private fun setShareIntent(shareIntent: Intent) {
        shareActionProvider?.setShareIntent(shareIntent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                Log.e("CheckMenu", "inside nav items listener")
                startActivity(Intent(baseContext, ShowallActivity::class.java))
                // Handle the camera action
            }
            R.id.nav_offers -> {
                startActivity(Intent(baseContext, OfferActivity::class.java))
            }

            R.id.nav_contact -> {

                val waIntent = Intent(Intent.ACTION_SEND)
                waIntent.type = "text/plain"
                val text = "YOUR TEXT HERE"

                startActivity(Intent(baseContext, HelpActivity::class.java))
            }
            R.id.nav_share -> {

                setShareIntent(Intent(Intent.ACTION_SEND))

                //  menuInflater.inflate(R.menu.activity_navigation_drawer, menu)

            }
            R.id.nav_send -> {
                val pm: PackageManager = packageManager
                val waIntent = Intent(Intent.ACTION_SEND)
                waIntent.type = "text/plain"
                val text = "YOUR TEXT HERE"
                val info: PackageInfo = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA)
                //Check if package exists or not. If not then code
                //in catch block will be called
                waIntent.setPackage("com.whatsapp");

                waIntent.putExtra(Intent.EXTRA_TEXT, text);
                startActivity(Intent.createChooser(waIntent, "Share with"));

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
