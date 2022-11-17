package com.example.archiver.ui.fragment.secondFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.archiver.R
import com.example.archiver.databinding.FragmentSecondBinding
import com.example.archiver.ui.base.BaseFragment
import java.io.File

class SecondFragment : BaseFragment<FragmentSecondBinding>(FragmentSecondBinding::inflate) {

    private val adapter = SecondAdapter()

    private val args by navArgs<SecondFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycleFile.adapter = adapter
        createFile(args.path)

        binding.acBar.imageButton.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }
    }

    private fun createFile(path: String) {
        binding.acBar.textView2.text = path
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