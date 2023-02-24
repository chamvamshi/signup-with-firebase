package com.example.signupapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class welcomescreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcomescreen)

        val Displayname = intent.getStringExtra(signIn.KEY2)
        val Displaymail = intent.getStringExtra(signIn.KEY1)

        val welcomeText = findViewById<TextView>(R.id.tvwelcome)
        val welcomename = findViewById<TextView>(R.id.tvvname)
        val welcomemail= findViewById<TextView>(R.id.tvvemail)

        welcomeText.text = "welcome $Displayname"
        welcomename.text = "name :$Displayname"
        welcomemail.text = "email :$Displaymail"


    }
}