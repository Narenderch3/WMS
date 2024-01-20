package com.example.wms

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class mainpage : AppCompatActivity() {

    private lateinit var FullName:EditText
    private lateinit var EmailAddress:EditText
    private lateinit var SetAPassword:EditText
    private lateinit var SelectyourNationality:EditText
    private lateinit var Submit:Button
    private lateinit var Email:EditText
    private lateinit var Loginpassword:EditText
    private lateinit var Loginsubmit:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainpage)

        FullName = findViewById(R.id.FullName)
        EmailAddress = findViewById(R.id.EmailAddress)
        SetAPassword = findViewById(R.id.SetAPassword)
        SelectyourNationality = findViewById(R.id.SelectyourNationality)
        Submit = findViewById(R.id.Submit)
        Email = findViewById(R.id.Email)
        Loginpassword = findViewById(R.id.Loginpassword)
        Loginsubmit = findViewById(R.id.Loginsubmit)
        
        Submit.setOnClickListener { 
            if (isValidSignup()){
                performSignup()
            }
            FullName.visibility = if (FullName.visibility == View.VISIBLE) View.GONE else View.VISIBLE
            EmailAddress.visibility = if (EmailAddress.visibility == View.VISIBLE) View.GONE else View.VISIBLE
            SetAPassword.visibility = if (SetAPassword.visibility == View.VISIBLE) View.GONE else View.VISIBLE
            SelectyourNationality.visibility = if (SelectyourNationality.visibility == View.VISIBLE) View.GONE else View.VISIBLE
        }

        Loginsubmit.setOnClickListener {
            if (isValidLogin()) {
                performLogin()
            }
            toggleVisibility(Email,Loginpassword)
        }

    }

    private fun isValidSignup(): Boolean {
        val FullName = FullName.text.toString()
        val EmailAddress = EmailAddress.text.toString()
        val Password = SetAPassword.text.toString()
        val Nationality = SelectyourNationality.text.toString()


        if (FullName.isEmpty() || EmailAddress.isEmpty() || Password.isEmpty() || Nationality.isEmpty() ){
            Toast("All fields are requidre")
            return false
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(EmailAddress).matches()) {
            Toast("Invalid email address")
            return false
        }
        return true
    }

    private fun performSignup() {
       Toast("signup Successfull")
    }

    private fun isValidLogin(): Boolean {
        val email = Email.text.toString()
        val loginPassword = Loginpassword.text.toString()

        if (email.isEmpty() || loginPassword.isEmpty()) {
            Toast("All fields are required for login")
            return false
        }
        return true
    }

    private fun performLogin() {
        Toast("Login is Sucessfull")
    }

    private fun toggleVisibility(vararg views: View) {
        views.forEach { view ->
            view.visibility = if (view.visibility == View.VISIBLE) View.GONE else View.VISIBLE
        }
    }

    private fun Toast(Message: String) {
        Toast.makeText(this, Message, Toast.LENGTH_SHORT).show()
    }
}