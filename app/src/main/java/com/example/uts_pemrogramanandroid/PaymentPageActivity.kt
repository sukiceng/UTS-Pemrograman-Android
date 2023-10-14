package com.example.uts_pemrogramanandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.Spinner
import android.widget.TextView
import com.example.uts_pemrogramanandroid.HomepageActivity.Companion.EXTRA_IMG
import com.example.uts_pemrogramanandroid.HomepageActivity.Companion.EXTRA_TITLE
import com.example.uts_pemrogramanandroid.databinding.PaymentPageBinding
import com.google.android.material.datepicker.MaterialDatePicker
import android.app.DatePickerDialog
import android.content.Intent
import android.util.Log
import java.util.Calendar
import java.util.Locale

class PaymentPageActivity : AppCompatActivity() {
       private lateinit var binding: PaymentPageBinding
       private var pilihBioskop : String = ""
        private var pilihKursi : String = ""
        private var pilihPembayaran : String = ""
        private var pilihBank : String = ""

    val hargaKursi = mapOf("Regular" to 35000,"Executive" to 50000,"Deluxe" to 75000)


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = PaymentPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra(DetailJohwickActivity.EXTRA_TITLE)
        val image = intent.getIntExtra(DetailJohwickActivity.EXTRA_IMG,0)
        val username = intent.getStringExtra(LoginPageActivity.EXTRA_USERNAME)

        val pilihanBioskop = resources.getStringArray(R.array.Pilihan_Bioskop)
        val pilihanKursi = resources.getStringArray(R.array.jenis_Kursi)
        val pilihanPembayaran = resources.getStringArray(R.array.Pilihan_Pembayaran)
        val pilihanBank = resources.getStringArray(R.array.Pilihan_Bank)

        with(binding){
            val adapterBioskop = ArrayAdapter(this@PaymentPageActivity, android.R.layout.simple_spinner_dropdown_item, pilihanBioskop)
            spinnerBioskop.adapter = adapterBioskop

            // Set an OnItemSelectedListener untuk "Pilih Bioskop" spinner
            spinnerBioskop.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long){
                    pilihBioskop = pilihanBioskop[position]
                    Log.d("pilihBioskop", pilihBioskop)
                }
                override fun onNothingSelected(parent: AdapterView<*>){
                    pilihBioskop = ""
                }
            }

            val adapterKursi = ArrayAdapter(this@PaymentPageActivity, android.R.layout.simple_spinner_dropdown_item, pilihanKursi)
            spinnerJenisKursi.adapter = adapterKursi

            // Set an OnItemSelectedListener untuk "Pilih Kursi" spinner
            spinnerJenisKursi.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long){
                    pilihKursi = pilihanKursi[position]
                    val harga = hargaKursi[pilihKursi]
                    if (harga != null){
                        showJenisKursi.text = pilihKursi
                        showJumlahHarga.text = "Rp." + harga.toString()
                        val biayaAdmin = 3000
                        val total = harga + biayaAdmin
                        showTotalHarga.text = "Rp." + total.toString()
                    }
                    Log.d("pilihKursi", pilihKursi)
                }
                override fun onNothingSelected(parent: AdapterView<*>){
                }
            }

            val adapterPembayaran = ArrayAdapter(this@PaymentPageActivity, android.R.layout.simple_spinner_dropdown_item, pilihanPembayaran)
            spinnerMetodePembayaran.adapter = adapterPembayaran

            // Set an OnItemSelectedListener untuk "Pilih Pembayaran" spinner
            spinnerMetodePembayaran.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long){
                    pilihPembayaran = pilihanPembayaran[position]
                    if (pilihPembayaran == "Transfer Bank"){
                        spinnerBank.visibility = View.VISIBLE
                        accountNumber.visibility = View.VISIBLE
                    } else{
                        spinnerBank.visibility = View.GONE
                        accountNumber.visibility = View.GONE }
                    Log.d("pilihPembayaran", pilihPembayaran)
                    }

                override fun onNothingSelected(parent: AdapterView<*>){
                    pilihPembayaran = ""
                }
            }
            val adapterBank = ArrayAdapter(this@PaymentPageActivity, android.R.layout.simple_spinner_dropdown_item, pilihanBank)
            spinnerBank.adapter = adapterBank

            // Set an OnItemSelectedListener untuk "Pilih Bank" spinner
            spinnerBank.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long){
                    pilihBank = pilihanBank[position]
                    Log.d("pilihBank", pilihBank)
                    }

                override fun onNothingSelected(parent: AdapterView<*>){
                    pilihBank = ""
                }
            }
            val pesanButton = binding.proceedTransactionBtn
            val datePicker = binding.pickerPilihTanggal



            // atur setOnclik untuk tombol kembali
            backBtn.setOnClickListener {
                val intent = Intent(this@PaymentPageActivity, HomepageActivity::class.java)
                startActivity(intent)
            }
            proceedTransactionBtn.setOnClickListener{
                val intent = Intent(this@PaymentPageActivity, OrderSummaryActivity::class.java)
                val pilihBioskop = pilihanBioskop[spinnerBioskop.selectedItemPosition]
                val pilihKursi = pilihanKursi[spinnerJenisKursi.selectedItemPosition]
                val pilihHarga = hargaKursi[pilihKursi]
                val pilihPembayaran = pilihanPembayaran[spinnerMetodePembayaran.selectedItemPosition]
                val pilihBank = pilihanBank[spinnerBank.selectedItemPosition]


//                val day = datePicker.dayOfMonth
//                val month = datePicker.month + 1
//                val year = datePicker.year
//                val selectedDate = String.format(Locale.getDefault(), "%02d-%02d-%04d", day, month, year)

                intent.putExtra("pilih", title)
                intent.putExtra(EXTRA_IMG,image)
                intent.putExtra(LoginPageActivity.EXTRA_USERNAME, username)
                intent.putExtra("pilihBioskop", pilihBioskop)
                intent.putExtra("pilihKursi", pilihKursi)
                intent.putExtra("pilihPembayaran", pilihPembayaran)
                intent.putExtra("pilihBank", pilihBank)
                intent.putExtra("pilihHarga", pilihHarga)


                startActivity(intent)
            }
        }
    }
}



