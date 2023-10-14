package com.example.uts_pemrogramanandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uts_pemrogramanandroid.HomepageActivity.Companion.EXTRA_IMG
import com.example.uts_pemrogramanandroid.HomepageActivity.Companion.EXTRA_TITLE
import com.example.uts_pemrogramanandroid.LoginPageActivity.Companion.EXTRA_USERNAME
import com.example.uts_pemrogramanandroid.databinding.DetailJohwickBinding

class DetailJohwickActivity : AppCompatActivity() {
    private lateinit var binding: DetailJohwickBinding

    companion object{
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_IMG = "extra_img"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailJohwickBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.getStringExtra(EXTRA_TITLE)
        val image = intent.getIntExtra(EXTRA_IMG,0)
        val username = intent.getStringExtra(EXTRA_USERNAME)
        with(binding){
            backBtn.setOnClickListener{
                val intDetailJohnWick = Intent(this@DetailJohwickActivity, HomepageActivity::class.java)
                intDetailJohnWick.putExtra(EXTRA_USERNAME, username)
                startActivity(intDetailJohnWick)
            }

        buyTicketBtn.setOnClickListener{
            val intDetailJohnWick = Intent(this@DetailJohwickActivity, PaymentPageActivity::class.java)
            startActivity(intDetailJohnWick)
            intDetailJohnWick.putExtra(EXTRA_TITLE, title)
            intDetailJohnWick.putExtra(EXTRA_IMG, image)
            intDetailJohnWick.putExtra(EXTRA_USERNAME, username)
            startActivity(intDetailJohnWick)
            }
        }
    }
}