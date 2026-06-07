package com.example.pratikum4

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Latihan4 : AppCompatActivity() {

    private var username: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        supportActionBar?.hide()
        delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
        setContentView(R.layout.activity_latihan4)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Ambil username yang dititipkan dari Latihan3
        username = intent.getStringExtra("username") ?: ""

        //Tampilkan HomeFragment sebagai default saat Activity baru dibuka
        if (savedInstanceState == null) {
            tampilkanFragment(HomeFragment())
        }

        //Pasang listener pada BottomNavigationView
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    tampilkanFragment(HomeFragment())
                    true // true = Home dipilih
                }
                R.id.menu_profile -> {
                    // Kirim username ke ProfileFragment lewat fungsi newInstance
                    tampilkanFragment(ProfileFragment.newInstance(username))
                    true // true = profile dipilih
                }
                R.id.menu_logout -> {
                    tampilkanDialogLogout()
                    false // false = Logout dipilih
                }
                else -> false // false atau cancel
            }
        }
    }

    //mengganti isi fragment container dengan fragment yang diberikan
    private fun tampilkanFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerLatihan4, fragment)
            .commit()
    }

    //tampilkan AlertDialog untuk konfirmasi logout
    private fun tampilkanDialogLogout() {
        AlertDialog.Builder(this)
            .setTitle("Konfirmasi Logout")
            .setMessage("Apakah Anda yakin ingin keluar dari aplikasi?")
            .setPositiveButton("Ya") { _, _ ->
                // User memilih Ya: kembali ke halaman Login (Latihan2)
                val intentLogout = Intent(this, Latihan2::class.java)
                // Bersihkan back stack: user tidak bisa back ke Latihan4 lagi
                intentLogout.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intentLogout)
                finish()
            }
            .setNegativeButton("Tidak", null) // null = tutup dialog tanpa aksi
            .show()
    }
}