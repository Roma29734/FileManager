package com.example.archiver.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.contains
import androidx.recyclerview.widget.RecyclerView
import com.example.archiver.databinding.FileRowBinding
import java.io.File

class FileAdapter(): RecyclerView.Adapter<FileAdapter.MyHolder>() {

    private var listItem = emptyList<File>()

    class MyHolder(val binding: FileRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(FileRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val listPositions = listItem[position]

        holder.binding.textNameFile.text = listPositions.name
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    fun setItem(list: List<File>) {
        listItem = list
        notifyDataSetChanged()
    }
}