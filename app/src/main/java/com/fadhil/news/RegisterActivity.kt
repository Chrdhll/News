package com.fadhil.news

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fadhil.news.api.ApiClient
import com.fadhil.news.models.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var etFullnama: EditText
    private lateinit var etEmail: EditText
    private lateinit var btnSignup: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register)

        etUsername = findViewById(R.id.etUsername) //copy:Ctrl+D
        etPassword = findViewById(R.id.etPassword)
        etFullnama = findViewById(R.id.etFullname)
        etEmail = findViewById(R.id.etEmail)
        btnSignup = findViewById(R.id.btnSignup)
        progressBar = findViewById(R.id.progressBar)


        btnSignup.setOnClickListener{
            prosesRegister()
        }
    }

    //Method proses register
    fun prosesRegister() {
        progressBar.visibility = View.VISIBLE
        ApiClient.apiService.register(
            etUsername.text.toString(),
            etPassword.text.toString(),
            etFullnama.text.toString(),
            etEmail.text.toString()
        ).enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                //Respone Berhsil
                if (response.isSuccessful) {
                    //jika berhasil menambahkan data user
                    //kondisi true => succes
                    if (response.body()!!.success) {
                        //arahkan ke loginactivity
                        startActivity(Intent(this@RegisterActivity,LoginActivity::class.java))
                        //pesan
                        Toast.makeText(
                            this@RegisterActivity,
                            response.body()!!.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }//kondisi false => succes
                    else{
                        Toast.makeText(
                            this@RegisterActivity,
                            response.body()!!.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
                progressBar.visibility = View.GONE
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                //Response Gagal
                Toast.makeText(
                    this@RegisterActivity,
                    t.message,
                    Toast.LENGTH_LONG
                ).show()
                progressBar.visibility = View.GONE
            }
        })
    }
}