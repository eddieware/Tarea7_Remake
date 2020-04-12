package com.example.tarea7_remake

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_list_users.*

class Login : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnCrearCuenta.setOnClickListener(this);
    }

    override fun onClick(v: View?) {
        val intSingUp = Intent(this@Login, SignUp::class.java)
        startActivity(intSingUp)
    }
}
