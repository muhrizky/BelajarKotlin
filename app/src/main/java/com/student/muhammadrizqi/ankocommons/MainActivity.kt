package com.student.muhammadrizqi.ankocommons

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*


class MainActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login_main.setOnClickListener {
            val username = ed_username_main.text.toString().trim()
            val password = ed_password_main.text.toString().trim()
            handleOnLogin(username = username, password = password)

        }
        text_view_accont_main.setOnClickListener {
            startActivity(intentFor<RegisterActivity>())
            Toast.LENGTH_SHORT
        }
    }

    private fun handleOnLogin(username: String, password: String) {
        debug { "username: $username and password: $password" }
        if (username == "rizqi" && password == "ganteng") {
            toast("Hi $username, You're Loggged in")
        } else {
            alert(title = getString(R.string.title_login_failed), message = getString(R.string.message_login_failed)) {
            positiveButton(buttonText = "OK"){

            }

            }.show()
        }
    }
}
