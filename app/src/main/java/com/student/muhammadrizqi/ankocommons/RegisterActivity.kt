package com.student.muhammadrizqi.ankocommons

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.alert
import org.jetbrains.anko.info
import org.jetbrains.anko.toast

class RegisterActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register_register.setOnClickListener {
            val fullname = ed_tex_full_name_register.text.toString().trim()
            val username = ed_username_register.text.toString().trim()
            val password = ed_password_register.text.toString().trim()
            handleOnRegister(fullname = fullname, username = username, password = password)
        }
    }

    private fun handleOnRegister(fullname: String, username: String, password: String) {
        info { "fullName: $fullname & username: $username & password : $password" }
        when {
            fullname.isEmpty() -> toast("Fullname is required.")
            username.isEmpty() -> toast("Username is required.")
            password.isEmpty() -> toast("Password is required.")
            else -> alert(title = "Register", message = "your account has been created") {


                positiveButton("OK") {
                    onBackPressed()
                }
            }.show()
        }
    }
}

