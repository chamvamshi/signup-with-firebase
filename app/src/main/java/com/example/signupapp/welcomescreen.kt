package com.example.signupapp

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.security.Key

class welcomescreen : AppCompatActivity() {

    lateinit var database : DatabaseReference
    lateinit var dialog :Dialog

    companion object{
        const val KEY1 = "com.example.signupapp.cetname"
        const val KEY2 = "com.example.signupapp.cetmail"
        const val KEY3 = "com.example.signupapp.cphone"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcomescreen)

        var myButton = findViewById<Button>(R.id.btnAdd)

        val name = findViewById<EditText>(R.id.name)
        val email=findViewById<EditText>(R.id.email)
        val phoneNumber = findViewById<EditText>(R.id.phonenumber)

        dialog = Dialog(this)
        dialog.setContentView(R.layout.cust_dialogue)
        var btnok = dialog.findViewById<Button>(R.id.btndismiss)
        var btndetail = dialog.findViewById<Button>(R.id.btndetials)
       btnok.setOnClickListener {

           dialog.dismiss()
       }

        myButton.setOnClickListener {
            val cetname = name.text.toString()
            val cetmail = email.text.toString()
            val cphone = phoneNumber.text.toString()


            val contacts = Contacts(cetname,cetmail,cphone)
            database = FirebaseDatabase.getInstance().getReference("contacts")

            database.child(cetname).setValue(contacts).addOnSuccessListener {
                Toast.makeText(this,"contacts added", Toast.LENGTH_LONG).show()

            }.addOnSuccessListener {
                Toast.makeText(this,"Failed", Toast.LENGTH_LONG).show()
            }
        }
        myButton.setOnClickListener {
            dialog.show()
        }
        btndetail.setOnClickListener {
            val cetname = name.text.toString()
            val cetmail = email.text.toString()
            val cphone = phoneNumber.text.toString()
            val contacts = Contacts(cetname , cetmail , cphone)

            database = FirebaseDatabase.getInstance().getReference("contacts")
            database.child(cetname).setValue(contacts).addOnSuccessListener {

                val opendetailsActivity = Intent(this,DetailsActivity::class.java)
                opendetailsActivity.putExtra(KEY1,cetname.toString())
                opendetailsActivity.putExtra(KEY2,cetmail.toString())
                opendetailsActivity.putExtra(KEY3,cphone.toString())
                startActivity(opendetailsActivity)

            }

        }




    }
}