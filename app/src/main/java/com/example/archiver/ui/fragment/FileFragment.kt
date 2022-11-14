package com.example.archiver.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.archiver.databinding.FragmentFileBinding
import com.example.archiver.ui.MainActivity


class FileFragment : Fragment() {

    private var _binding: FragmentFileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        _binding = FragmentFileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun visibleText() {
        binding.textNonData.visibility = View.VISIBLE
    }

    override fun onStart() {
        super.onStart()
        val activity = (requireActivity() as MainActivity)

        if(!activity.checkPermission()) {
            activity.requestPermission()
            visibleText()
        } else {
            Toast.makeText(context, "wery goood", Toast.LENGTH_SHORT).show()
        }

    }
}