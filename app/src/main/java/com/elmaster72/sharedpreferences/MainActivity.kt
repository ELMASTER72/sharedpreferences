package com.elmaster72.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var campoUsuario: EditText? = null
    var campoPass: EditText? = null
    var txtUsuario: TextView? = null
    var txtPass: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniciarComponentes()

    }

    private fun iniciarComponentes() {

        var btnGuardar: Button = findViewById(R.id.button_save)
        btnGuardar.setOnClickListener { guardarDatos() }

        var btnCargar: Button = findViewById(R.id.button_change)
        btnCargar.setOnClickListener { cargarDatos() }

        campoUsuario = findViewById(R.id.editTextTextPersonName)
        campoPass = findViewById(R.id.editTextTextPassword2)
        txtUsuario = findViewById(R.id.lblusuario)
        txtPass = findViewById(R.id.lblcontraseña)

    }

    private fun guardarDatos() {

        var preferences: SharedPreferences =
            getSharedPreferences("credenciales", Context.MODE_PRIVATE)

        var usuario = campoUsuario?.text.toString()
        var pass = campoPass?.text.toString()

        var editor: SharedPreferences.Editor = preferences.edit()
        editor.putString("user", usuario)
        editor.putString("pass", pass)

        txtUsuario?.text=usuario
        txtPass?.text=pass

        editor.commit()

        Toast.makeText(this, "Se han registrado los datos", Toast.LENGTH_SHORT).show()


    }

    private fun cargarDatos() {
        val intent = Intent(this,Result::class.java)
        startActivity(intent)
    }
}
