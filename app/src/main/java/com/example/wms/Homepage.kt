package com.example.wms

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView


class Homepage : AppCompatActivity() {

    private lateinit var cardView1 : CardView
    private lateinit var cardView2 : CardView
    private lateinit var login : Button
    private var isLoggedIn = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)


        cardView1 = findViewById(R.id.cardview_1)
        cardView2 = findViewById(R.id.cardview_2)
        login = findViewById(R.id.login)

        cardView1.setOnClickListener {
            showToast("cardview clicked")

            val intent = Intent(this,Mainpage::class.java)
            startActivity(intent)
        }

        cardView2.setOnClickListener {
            ShowToast("cardvied clicked")

            val intent = Intent(this,Mainpage::class.java)
            startActivity(intent)

        }

        login.setOnClickListener {
            showToast("login clicked")

            val intent = Intent(this,Loginpage::class.java)
            startActivity(intent)
        }

        login.setOnClickListener {
            isLoggedIn = true
            showToast("Logged in successfully")
        }

//        val otherButton= null
//        otherButton.setOnClicklistener{
//            if (isLoggedIn){
//                showToast("Button clicked,performing action")
//                startActivity(Intent(this,Loginpage::class.java))
//            } else {
//                showToast("Please log in first")
//            }
//        }

    }

    private fun ShowToast(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()

    }

    private fun showToast(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()

    }

}

