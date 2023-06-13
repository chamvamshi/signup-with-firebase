package com.example.signupapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val contactsDetails1 = intent.getStringExtra(welcomescreen.KEY1)
        val contactsDetails2 = intent.getStringExtra(welcomescreen.KEY2)
        val contactsDetails3 = intent.getStringExtra(welcomescreen.KEY3)

        val name = findViewById<TextView>(R.id.disname)
        val mail= findViewById<TextView>(R.id.disemail)
        val phone = findViewById<TextView>(R.id.disphone)

       name.text = "name :$contactsDetails1"
        mail.text = "mail : $contactsDetails2"
        phone.text = "phone:  $contactsDetails3"
    }
}