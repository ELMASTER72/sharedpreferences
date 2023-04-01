package com.elmaster72.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val txtUsuario = findViewById<TextView>(R.id.lblUser)
        val txtPass = findViewById<TextView>(R.id.lblpassword)

        var preferences:SharedPreferences=getSharedPreferences("credenciales",Context.MODE_PRIVATE)

        var user: String? =preferences.getString("user","No existe la información")
        var pass: String? =preferences.getString("pass","No existe la información")

        txtUsuario?.text=user
        txtPass?.text=pass

        val final = findViewById<Button>(R.id.btn_final)
        final.setOnClickListener { onClick() }
    }

    private fun onClick(){
        finish()
    }

}