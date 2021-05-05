package mx.arr.androidexam

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var etUser : EditText
    private lateinit var etPass : EditText

    private lateinit var prefs : SharedPreferences
    private lateinit var editor : SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUser = findViewById(R.id.itUser)
        etPass = findViewById(R.id.itPassword)

        prefs = getSharedPreferences("Login", Context.MODE_PRIVATE)
        editor = prefs.edit()

        verificarLogin()

    }

    private fun verificarLogin() {
        if (prefs.contains("userP")){
            val intNewsFeed = Intent(this, NewsFeed::class.java)
            startActivity(intNewsFeed)
            finish()
        }
    }

    fun guardarDatos(v: View){
        val usuario = etUser.text.toString()
        val contraseña = etPass.text.toString()

        editor.putString("userP", usuario)
        editor.putString("passP", contraseña)
        editor.commit()

        val intNewsFeed = Intent(this, NewsFeed::class.java)
        startActivity(intNewsFeed)
        finish()
    }

}