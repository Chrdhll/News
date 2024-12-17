package com.fadhil.news

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fadhil.news.api.ApiClient
import com.fadhil.news.models.RegisterRequest
import com.fadhil.news.models.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var btnregister : Button
    private lateinit var btnLogin : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnregister = findViewById(R.id.btnRegistrasi)
        btnLogin = findViewById(R.id.btnLogin)

        btnregister.setOnClickListener(){
            startActivity(Intent(this,RegisterActivity::class.java))
        }

        btnLogin.setOnClickListener(){
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}