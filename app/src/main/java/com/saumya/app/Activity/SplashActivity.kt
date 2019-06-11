package com.saumya.app.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.saumya.app.R

class SplashActivity : AppCompatActivity() {

    private var m: Handler? = null
    private val SplashLenght: Long = 2000
    private val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
            startActivity(Intent(baseContext, LoginActivity::class.java))
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        m = Handler()
        m!!.postDelayed(mRunnable, SplashLenght)
//        FirebaseApp.initializeApp(baseContext)
//        val firebaseUser = FirebaseAuth.getInstance().currentUser
//        linear.setOnClickListener {
//        if (firebaseUser != null) {
//            startActivity(Intent(baseContext, NavigationActivity::class.java))
//        } else {
//            startActivityForResult(
//                AuthUI.getInstance().createSignInIntentBuilder().setIsSmartLockEnabled(true).setAvailableProviders(
//                    Arrays.asList(AuthUI.IdpConfig.PhoneBuilder().build())
//                ).build(), Requestcode
//            )
//        }

    }

    override fun onDestroy() {
        if (m != null)
            m!!.removeCallbacks(mRunnable)
        super.onDestroy()
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == Requestcode) {
//
//            val response = IdpResponse.fromResultIntent(data)
//            if (resultCode == Activity.RESULT_OK) {
//                startActivity(Intent(baseContext,NavigationActivity::class.java))}
////            } else {
////                if (response == null)
////                    return
////            }
//        }
//    }
}


