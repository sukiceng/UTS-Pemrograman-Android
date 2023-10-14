package com.example.uts_pemrogramanandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.Spinner
import com.example.uts_pemrogramanandroid.databinding.ActivityMainBinding
import java.util.Locale

class PaymentPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var pilihBioskop : Array<String>
    private lateinit var pilihKursi : Array<String>
    private lateinit var pilihTanggal : DatePicker
    private lateinit var pilihPembayaran : Array<String>
    private lateinit var pilihBank : Array<String>
    private lateinit var lanjutBayar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.payment_page)
        super.onCreate(savedInstanceState)
        // Mengambil array dari string
        pilihBioskop = resources.getStringArray(R.array.Pilihan_Bioskop)
        pilihKursi = resources.getStringArray(R.array.Pilih_jenis_kursi)
        pilihPembayaran = resources.getStringArray(R.array.Pilihan_Pembayaran)
        pilihBank = resources.getStringArray(R.array.Pilihan_Bank)
        pilihTanggal = findViewById(R.id.picker_pilih_tanggal)

        // Inisialisasi elemen UI spinner
        initSpinnerBioskop()
        initSpinnerJenisKursi()
        initDatePicker()
        initSpinnerMetodePembayaran()
        initSpinnerBank()
        initSelectedDate()
    }
    // fungsi untuk inisiasi UI spinner
    private fun initSpinnerBioskop() {
        val spinnerBioskop = this.findViewById<Spinner>(R.id.spinner_bioskop)
        val adapterBioskop = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, pilihBioskop)
        spinnerBioskop.adapter = adapterBioskop
    }
    private fun initSpinnerJenisKursi() {
        val spinnerKursi = findViewById<Spinner>(R.id.spinner_jenis_kursi)
        val adapterKursi = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, pilihKursi)
        spinnerKursi.adapter = adapterKursi
    }
    private fun initDatePicker() {
        pilihTanggal = findViewById(R.id.picker_pilih_tanggal)
    }
    private fun initSpinnerMetodePembayaran() {
        val spinnerPembayaran = findViewById<Spinner>(R.id.spinner_metode_pembayaran)
        val adapterPembayaran = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, pilihPembayaran)
        spinnerPembayaran.adapter = adapterPembayaran
    }
    private fun initSpinnerBank() {
        val spinnerBank = findViewById<Spinner>(R.id.spinner_bank)
        val adapterBank = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, pilihBank)
        spinnerBank.adapter = adapterBank
    }
    private fun initSelectedDate(): String {
        val day = pilihTanggal.dayOfMonth
        val month = pilihTanggal.month + 1
        val year = pilihTanggal.year

        return String.format(Locale.getDefault(), "%02d/%02d/%04d", day, month, year)
    }
}