package com.explorewithnik.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    //Activity lifecycle is like a main() function in java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //entry point
        //invokes just once
        //Use it for logic that should happen only once
        //Activity is not yet visible to user
        //ex setup UI, initialise viewModel or observe a liveData

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show()

        //go to grocery store activity
        btn.setOnClickListener {
           startActivity(Intent(this, GroceryStoreActivity::class.java))
        }

        //go to dialog activity
        btn_dialog.setOnClickListener {
            startActivity(Intent(this, DialogActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        //Activity is visible and in background
        //invokes multiple times
        //it get invokes when user opens another activity and then press the back button
        //user can't interact with it, like: pressing a button or scroll the list
        //typical usage of this callback is to initialise components that you released during
        //onStop() function or adjust some resources
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        //Activity is visible and in foreground
        //invokes multiple times
        //user can interact with it in any way, like: pressing a button or scroll the list, etc

        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
    }


    override fun onPause() {
        super.onPause()
        //Activity is visible and in background
        //invokes multiple times
        //system calls this method when our activity losses the focus, ex user navigates to different activity
        //first indication that a user leaves activity
        //typical usage is to pause the operations that are not needed ex animations,
        //releases unneeded light resources like broadcast receivers, gps sensors or any other resources that you don't need
        //remember that everything that you released should be initialised again in onResume() function
        //don't call any heavy load shutdown operations
        //onPause should be performed under 10ms

        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        //Activity is in memory and not visible to user
        //use it to release heavy resources or save the user data, database transaction or network calls
        //get invokes when user navigate to another activity or press the home button
        //android system can kill the application process from this state in case of low memory
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        //activity is not visible to user
        //it will be called whenever the Activity comes back from the invisible state
        //ex - when user opens another activity and then press the back button
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        //end point
        //invokes just once in lifecycle
        //final callback that a activity receives
        //it happens in two cases :-
        //1. configuration changes ex- rotation or change the language from the settings
        //2. activity is finished ex- manually called finish() function from the code or killed by the sytem
        //you shouldn't rely on this callback, in case of low memory the system can
        //kill the application process and onDestroy() might not get invoked, better to rely on onStop() function
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()
    }
}