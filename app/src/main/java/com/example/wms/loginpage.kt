package com.example.wms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wms.databinding.ActivityLoginpageBinding

class loginpage : AppCompatActivity() {

    lateinit var binding: ActivityLoginpageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginpageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}