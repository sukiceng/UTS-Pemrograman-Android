package com.example.uts_pemrogramanandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uts_pemrogramanandroid.databinding.DetailDeadreckoningBinding
import com.example.uts_pemrogramanandroid.databinding.DetailJamesbondBinding

class DetailDeadreckoningActivity : AppCompatActivity() {
    private lateinit var binding: DetailDeadreckoningBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailDeadreckoningBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.getStringExtra(HomepageActivity.EXTRA_TITLE)
        val image = intent.getIntExtra(HomepageActivity.EXTRA_IMG,0)
        val username = intent.getStringExtra(LoginPageActivity.EXTRA_USERNAME)
        with(binding){
            backBtn.setOnClickListener{
                val intDetailDeadReckoning = Intent(this@DetailDeadreckoningActivity, HomepageActivity::class.java)
                intDetailDeadReckoning.putExtra(LoginPageActivity.EXTRA_USERNAME, username)
                startActivity(intDetailDeadReckoning)
            }

            buyTicketBtn.setOnClickListener{
                val  intDetailDeadReckoning= Intent(this@DetailDeadreckoningActivity, PaymentPageActivity::class.java)
                intDetailDeadReckoning.putExtra(HomepageActivity.EXTRA_TITLE, title)
                intDetailDeadReckoning.putExtra(HomepageActivity.EXTRA_IMG, image)
                intDetailDeadReckoning.putExtra(LoginPageActivity.EXTRA_USERNAME, username)
                startActivity(intDetailDeadReckoning)
            }
        }
    }
}