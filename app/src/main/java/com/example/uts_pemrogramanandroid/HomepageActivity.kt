package com.example.uts_pemrogramanandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uts_pemrogramanandroid.LoginPageActivity.Companion.EXTRA_USERNAME
import com.example.uts_pemrogramanandroid.databinding.HomepageBinding

class HomepageActivity : AppCompatActivity() {
    private lateinit var binding: HomepageBinding

    companion object {
        const val EXTRA_TITLE = "EXTRA_TITLE"
        const val EXTRA_IMG = "EXTRA_IMG"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(EXTRA_USERNAME)
        with(binding){
            displayUsername.text = "$username"
            cardview1.setOnClickListener{
                val intent = Intent(this@HomepageActivity, DetailJohwickActivity::class.java).apply {
                    putExtra(EXTRA_TITLE, title1.text.toString())
                    putExtra(EXTRA_IMG, R.drawable.john_wick_ch4)
                }
                startActivity(intent)
            }
            cardview2.setOnClickListener{
                val intent = Intent(this@HomepageActivity, DetailJamesbondActivity::class.java).apply {
                    putExtra(EXTRA_TITLE, title2.text.toString())
                    putExtra(EXTRA_IMG, R.drawable.no_time_to_die)
                }
                startActivity(intent)
            }
            cardview3.setOnClickListener{
                val intent = Intent(this@HomepageActivity, DetailDeadreckoningActivity::class.java).apply{
                    putExtra(EXTRA_TITLE, title3.text.toString())
                    putExtra(EXTRA_IMG, R.drawable.dead_reckoning)
                }
                startActivity(intent)
            }

        }
    }
}