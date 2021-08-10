package com.example.talkademy_phase4.phase6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.talkademy_phase4.databinding.ItemRecyclerViewBinding

class RecyclerItemAdapter(
    private val data: ArrayList<String>
) : RecyclerView.Adapter<RecyclerItemAdapter.ItemViewHolder>() {

    private lateinit var binding: ItemRecyclerViewBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        binding =
            ItemRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemViewHolder(binding.root)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.setText(data[position])
    }

    override fun getItemCount(): Int = data.size

    fun addItem(text: String) {
        data.add(text)
        //notifyDataSetChanged()
        notifyItemInserted(data.size - 1)
    }

    fun getItems(): List<String> = data

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setText(text: String) {
            if (::binding.isInitialized)
                binding.textViewItemRecyclerView.text = text
        }
    }

}