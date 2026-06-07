package com.example.pratikum4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.pratikum4.R

class MatakuliahAdapter(
    private val daftarMatakuliah: List<Matakuliah>
) : RecyclerView.Adapter<MatakuliahAdapter.MatakuliahViewHolder>() {

    class MatakuliahViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvKodeMK: TextView = view.findViewById(R.id.tvKodeMK)
        val tvSksMK: TextView = view.findViewById(R.id.tvSksMK)
        val tvNamaMK: TextView = view.findViewById(R.id.tvNamaMK)
        val tvDosenMK: TextView = view.findViewById(R.id.tvDosenMK)
        val tvJadwalMK: TextView = view.findViewById(R.id.tvJadwalMK)
        val tvRuanganMK: TextView = view.findViewById(R.id.tvRuanganMk)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MatakuliahViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_matakuliah, parent, false)
        return MatakuliahViewHolder(view)
    }

    override fun onBindViewHolder(holder: MatakuliahViewHolder, position: Int) {

        // Ambil data sesuai posisi
        val item = daftarMatakuliah[position]

        // Isi tiap TextView dengan data
        holder.tvKodeMK.text = item.id_matakuliah
        holder.tvSksMK.text = "${item.sks_matakuliah} SKS"
        holder.tvNamaMK.text = item.nama_matakuliah
        holder.tvDosenMK.text = item.nama_dosen_matakuliah
        holder.tvJadwalMK.text = item.jadwal_matakuliah
        holder.tvRuanganMK.text = item.ruangan_matakuliah

        // Pasang event klik pada seluruh item
        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Matakuliah dipilih: ${item.nama_matakuliah}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    //Total jumlah item yang akan ditampilkan
    override fun getItemCount(): Int = daftarMatakuliah.size
}
