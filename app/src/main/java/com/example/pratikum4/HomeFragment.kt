package com.example.pratikum4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val daftarMatakuliah = listOf(
            Matakuliah("P01", "Pemrograman Berorientasi Objek", 3, "Dosen: Wanvy Arifha Saputra", "Jadwal: Senin, 13:00 - 16:00", "Ruangan: Lab PBL"),
            Matakuliah("P02", "Matematika", 2, "Dosen: Isna Wardiah", "Jadwal: Senin, 08:00 - 10:00", "Ruangan: H-101"),
            Matakuliah("P03", "Basisdata", 3, "Dosen: M. Helmy Noor", "Jadwal: Selasa, 08:00 - 10:00", "Ruangan: Lab RPL"),
            Matakuliah("P04", "Rekayasa Perangkat Lunak", 3, "Dosen: Rahimi Fitri", "Jadwal: Selasa, 13:00 - 16:00", "Ruangan: Lab RPL"),
            Matakuliah("P05", "Bahasa Inggris", 2, "Dosen: Siti Kustini", "Jadwal: Rabu, 08:00 - 10:00", "Ruangan: H-101"),
            Matakuliah("P06", "Struktur Data", 3, "Dosen: Saberan", "Jadwal: Rabu, 13:00 - 16:00", "Ruangan: Lab RPL"),
            Matakuliah("P07", "Jaringan Lanjut", 3, "Dosen: Arifin Noor Asyikin", "Jadwal: Kamis, 08:00 - 10:00", "Ruangan: Lab Jarkom"),
            Matakuliah("P08", "Interaksi Manusia dan Komputer", 2, "Dosen: Ahmad Yusuf", "Jadwal: Kamis, 13:00 - 16:00", "Ruangan: H-101"),
        )
        val rvMatakuliah = view.findViewById<RecyclerView>(R.id.rvMatakuliah)
        rvMatakuliah.layoutManager = LinearLayoutManager(requireContext())
        rvMatakuliah.adapter = MatakuliahAdapter(daftarMatakuliah)

        return view

    }
}