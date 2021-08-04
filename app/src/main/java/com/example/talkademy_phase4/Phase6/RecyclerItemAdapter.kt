package com.example.talkademy_phase4.Phase6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.talkademy_phase4.databinding.RecyclerItemViewBinding

class RecyclerItemAdapter(
    private val data: ArrayList<String>
) : RecyclerView.Adapter<RecyclerItemAdapter.ItemViewHolder>() {

    private lateinit var binding: RecyclerItemViewBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        binding =
            RecyclerItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemViewHolder(binding.root)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.setText(data[position])
    }

    override fun getItemCount(): Int = data.size

    fun addItem(text: String){
        data.add(text)
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setText(text: String) {
            binding.textViewItemRecyclerView.text = text
        }
    }

}