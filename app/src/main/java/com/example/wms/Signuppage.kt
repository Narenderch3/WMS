@file:Suppress("unused")

package com.example.wms

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import na

class Signuppage : AppCompatActivity() {

    private lateinit var fullName: EditText
    private lateinit var emailAddress: EditText
    private lateinit var setPassword: EditText
    private lateinit var submit: Button
    private lateinit var spinner: Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signuppage)

        fullName = findViewById(R.id.FullName)
        emailAddress = findViewById(R.id.EmailAddress)
        setPassword = findViewById(R.id.SetAPassword)
        submit = findViewById(R.id.Submit)


        val spinnerCountries:Spinner = findViewById(R.id.spinnerCountries)
//        val nationalityAdapater = nationalityadapater()
        val countryList = arrayOf("India", "USA", "Canada", "Australia", "Brazil", "China", "Germany", "Japan", "Mexico", "South Africa")
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,countryList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCountries.adapter = adapter

        spinnerCountries.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                val selectedCountry = countryList[position]
                showToast("Selected country: $selectedCountry")
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {

            }
        }

        submit.setOnClickListener {
            if (isValidSignup()) {
                performSignup()
            }
        }
    }

    private fun performSignup() {
        Toast("Signup is Successful")

        val intent = Intent(this, Homepage::class.java)
        startActivity(intent)

    }

    private fun isValidSignup(): Boolean {
        val fullNameStr = fullName.text.toString()
        val emailAddressStr = emailAddress.text.toString()
        val setPasswordStr = setPassword.text.toString()

        if (fullNameStr.isEmpty() || !Validator.isFullNameValid(fullNameStr)) {
            Toast("Invalid Full Name")
            return false
        }

        if (emailAddressStr.isEmpty() || !Validator.isEmailAddressValid(emailAddressStr)) {
            Toast("Invalid Email Address")
            return false
        }

        if (setPasswordStr.isEmpty() || !Validator.isPasswordValid(setPasswordStr)) {
            Toast("Invalid Password. It should contain at least 8 characters with letters and digits.")
            return false
        }

        return true

    }

    private fun showToast(massage: String) {
        Toast.makeText(this,massage,Toast.LENGTH_SHORT).show()

    }

    private fun Toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    class Validator {
        companion object {
            fun isFullNameValid(name: String): Boolean {
                val regex = "^[a-zA-Z]+(\\s[a-zA-Z]+)*\$"
                return name.matches(regex.toRegex())
            }

            fun isPasswordValid(password: String): Boolean {
                val regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$"
                return password.matches(regex.toRegex())
            }

            fun isEmailAddressValid(emailAddress: String): Boolean {
                val regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,4}\$"
                return emailAddress.matches(regex.toRegex())
            }
        }
    }
}



