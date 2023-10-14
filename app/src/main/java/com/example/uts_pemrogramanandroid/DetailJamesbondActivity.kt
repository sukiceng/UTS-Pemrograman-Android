package com.example.uts_pemrogramanandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uts_pemrogramanandroid.databinding.DetailJamesbondBinding
import com.example.uts_pemrogramanandroid.databinding.DetailJohwickBinding

class DetailJamesbondActivity : AppCompatActivity() {
    private lateinit var binding: DetailJamesbondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailJamesbondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.getStringExtra(HomepageActivity.EXTRA_TITLE)
        val image = intent.getIntExtra(HomepageActivity.EXTRA_IMG,0)
        val username = intent.getStringExtra(LoginPageActivity.EXTRA_USERNAME)
        with(binding){
            backBtn.setOnClickListener{
                val intDetailJamesBond = Intent(this@DetailJamesbondActivity, HomepageActivity::class.java)
                intDetailJamesBond.putExtra(LoginPageActivity.EXTRA_USERNAME, username)
                startActivity(intDetailJamesBond)
            }

            buyTicketBtn.setOnClickListener{
                val intDetailJamesbond = Intent(this@DetailJamesbondActivity, PaymentPageActivity::class.java)
                intDetailJamesbond.putExtra(HomepageActivity.EXTRA_TITLE, title)
                intDetailJamesbond.putExtra(HomepageActivity.EXTRA_IMG, image)
                intDetailJamesbond.putExtra(LoginPageActivity.EXTRA_USERNAME, username)
                startActivity(intDetailJamesbond)
            }
        }
    }
}