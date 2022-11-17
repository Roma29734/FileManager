package com.example.archiver.ui.fragment.file

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.navArgs
import com.example.archiver.databinding.FragmentFileBinding
import com.example.archiver.ui.base.BaseFragment
import java.io.File


class FileFragment : BaseFragment<FragmentFileBinding>(FragmentFileBinding::inflate) {

    private val adapter = FileAdapter()

    private val args by navArgs<FileFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycleFile.adapter = adapter

        createFile(args.path)
        Log.d("fileFragment", args.path)
    }

    private fun createFile(path: String) {
        val root = File(path)
        val filesAndFolders = root.listFiles()
        if (filesAndFolders == null || filesAndFolders.isEmpty()) {
            Log.d("FileFragment", "Пустая дериктория")
            binding.textNonData.visibility = View.VISIBLE
            return
        }
        binding.textNonData.visibility = View.INVISIBLE
        updateUi(filesAndFolders)
    }

    private fun updateUi(filesAndFolders: Array<File>) {
        Log.d("fileAdapter", "устанавливаю: $filesAndFolders")
        adapter.setItem(filesAndFolders)
    }
}