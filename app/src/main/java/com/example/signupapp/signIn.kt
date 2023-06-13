package com.example.signupapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.lang.ref.PhantomReference
import java.lang.ref.Reference
import java.security.Key

class signIn : AppCompatActivity() {

    lateinit var databaseReference : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val signbutton = findViewById<Button>(R.id.signInbtn)
        val username = findViewById<TextInputEditText>(R.id.edittextusername)

        signbutton.setOnClickListener {
            val usernamestring = username.text.toString()
            if (usernamestring.isNotEmpty()) {
                readData(usernamestring)
            }else{
                Toast.makeText(this,"please enter name",Toast.LENGTH_LONG).show()
            }
            }
        }// oncreate Method over till here....!!!!!

    private fun readData(usernamestring: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("users")
        databaseReference.child(usernamestring).get().addOnSuccessListener {

           if (it.exists()){
               //check that user exits or not
               val email = it.child("etmail").value
               val name = it.child("etname").value

               val openwelcome = Intent(this,welcomescreen::class.java)
               startActivity(openwelcome)


           }else{
               Toast.makeText(this,"user doesn't exist please sign up",Toast.LENGTH_LONG).show()
           }

        }.addOnFailureListener {
            Toast.makeText(this,"failed",Toast.LENGTH_LONG).show()
        }

    }
}
