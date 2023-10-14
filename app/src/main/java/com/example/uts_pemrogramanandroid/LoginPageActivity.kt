package com.example.uts_pemrogramanandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.uts_pemrogramanandroid.databinding.ActivityMainBinding
import com.example.uts_pemrogramanandroid.databinding.LoginPageBinding

class LoginPageActivity : AppCompatActivity() {
    private lateinit var binding: LoginPageBinding
    companion object {
        const val EXTRA_USERNAME = "com.example.uts_pemrogramanandroid.MESSAGE"
        const val EXTRA_PASSWORD = "com.example.uts_pemrogramanandroid.MESSAGE"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user1 = arrayOf("anonimus", "lingsirwengi")

        with(binding) {
            submitBtn.setOnClickListener {
                val username = inputUsername.text.toString()
                val password = inputPassword.text.toString()
                if (username == user1[0] && password == user1[1]) {
                    val intent = Intent(this@LoginPageActivity, HomepageActivity::class.java).apply {
                        putExtra(EXTRA_USERNAME, username)
                        putExtra(EXTRA_PASSWORD, password)
                    }
                    startActivity(intent)
                } else {
                    Toast.makeText(this@LoginPageActivity, "Username atau Password salah", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}