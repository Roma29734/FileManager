package com.example.archiver.ui.fragment.secondFragment

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.archiver.R
import com.example.archiver.databinding.FileRowBinding
import java.io.File

class SecondAdapter(

): RecyclerView.Adapter<SecondAdapter.MyHolder>() {

    private var fileList: Array<File>? = null
    private lateinit var filesList: Array<File>

    class MyHolder(val binding: FileRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(FileRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val selectedFile = fileList?.get(position)
        if (selectedFile != null) {
            holder.binding.textNameFile.text = selectedFile.name
            if (selectedFile.isDirectory) {
                holder.binding.imageView.setImageResource(R.drawable.ic_baseline_folder_24)
            } else {
                holder.binding.imageView.setImageResource(R.drawable.ic_file)
            }
        }

        holder.binding.file.setOnClickListener {
            if (selectedFile != null) {
                if(selectedFile.isDirectory) {
                    val path = selectedFile.absolutePath
                    Log.d("fileAdapter", path)
//                    view?.let { Navigation.findNavController(it).navigate(R .id.action_fileFragment_to_secondFragment) }
                    val action = SecondFragmentDirections.actionSecondFragmentSelf(path)
                    holder.itemView.findNavController().navigate(action)
                }else {
                    Log.d("fileAdapter","нажали не на папку..")
                }
            }
        }
    }

    override fun getItemCount(): Int {
        Log.d("fileAdapter","вызван getItemCount")
        return fileList?.size ?: 0
    }
    //
    fun setItem(list: Array<File>) {
        fileList = list
        Log.d("fileAdapter", "пришел лист: $list")
        Log.d("fileAdapter", "установил лист: $fileList")
        notifyDataSetChanged()
    }
}