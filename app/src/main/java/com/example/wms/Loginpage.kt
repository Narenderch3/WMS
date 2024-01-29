package com.example.wms

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Loginpage : AppCompatActivity() {

    private lateinit var Email : EditText
    private lateinit var Password : EditText
    private lateinit var Loginsubmit :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginpage)

        Email = findViewById(R.id.Email)
        Password = findViewById(R.id.Loginpassword)
        Loginsubmit = findViewById(R.id.Loginsubmit)

//        Loginsubmit.setOnClickListener {
//          showLoginpopup()
//            dialog.dismiss()
//            }
//    }
//
//    private fun showLoginpopup() {
//        val dialog = Dialog(this)
//        dialog.setContentView(R.layout.activity_loginpage1)
//        val Loginsubmit = dialog.findViewById<Button>(R.id.Loginsubmit)

        Loginsubmit.setOnClickListener {
            if (isValidLogin()){
                performLogin()
            }
        }
    }

    private fun performLogin() {
        Toast.makeText(this,"Login is Sucessfull",Toast.LENGTH_SHORT).show()

        val intent = Intent(this,Homepage::class.java)
        startActivity(intent)
    }

    private fun isValidLogin(): Boolean {
        val Emailstr = Email.text.toString()
        val Passwordstr = Password.text.toString()

        if (Emailstr.isEmpty() || !Validator.isEmailValid(Emailstr)){
            Toast("Invalid email address")
            return false
    }
        if (Passwordstr.isEmpty()|| !Validator.isPasswordValid(Passwordstr)){
            Toast("Invalid Password")
            return false
        }
        return true
    }

    private fun Toast(message: String) {
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show()

    }

    class Validator {
        companion object {
            fun isEmailValid(email: String): Boolean {
                // Android's built-in pattern matcher for email addresses
                val regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,4}\$"
                return email.matches(regex.toRegex())
            }
            fun isPasswordValid(password: String): Boolean {
                // Regular expression for a valid password (Minimum 8 characters, at least one letter and one digit)
                val regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$"
                return password.matches(regex.toRegex())
            }
        }
    }
}

