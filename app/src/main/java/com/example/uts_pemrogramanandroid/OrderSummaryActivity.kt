package com.example.uts_pemrogramanandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.uts_pemrogramanandroid.HomepageActivity.Companion.EXTRA_TITLE
import com.example.uts_pemrogramanandroid.databinding.OrderSummaryBinding

class OrderSummaryActivity : AppCompatActivity() {
    private lateinit var binding: OrderSummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = OrderSummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(LoginPageActivity.EXTRA_USERNAME)
        val name = intent.getStringExtra(EXTRA_TITLE)
        val terimaGambar = findViewById<ImageView>(R.id.getImage)
        val image = intent.getIntExtra(HomepageActivity.EXTRA_IMG, 0)
        if(image != null){
            terimaGambar.setImageResource(image)
        }
        with(binding){
            judulTicket.text = name
            kembali.setOnClickListener{
                val intDetailDeadReckoning = Intent(this@OrderSummaryActivity, HomepageActivity::class.java)
                intent.putExtra(LoginPageActivity.EXTRA_USERNAME, username)
                startActivity(intDetailDeadReckoning)
            }
            val terimaJudul= intent.getStringExtra("pilihjudul")
            judulTicket.text = terimaJudul

//            val terimaGambar = intent.getIntExtra("pilihgambar",0)
//            terimaGambar.setImageResource(terimaGambar)


            val terimaBioskop = intent.getStringExtra("pilihBioskop")
            detailBioskop.text = terimaBioskop
            val terimaTanggal = intent.getStringExtra("EXTRA_TANGGAL")
            tanggalPemesanan.text = terimaTanggal
            var terimaKursi = intent.getStringExtra("EXTRA_KURSI")
            seatType.text = terimaKursi
            val terimaJenispembayaran = intent.getStringExtra("EXTRA_JENISPEMBAYARAN")
            paymentMethod.text = terimaJenispembayaran
            val terimaHarga = intent.getStringExtra("EXTRA_HARGA")
            val hargaTicket= terimaHarga
            val terimaService = intent.getStringExtra("EXTRA_SERVICE")
        }
    }
}
