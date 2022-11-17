package com.example.archiver.ui.fragment

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import com.example.archiver.R
import com.example.archiver.databinding.FragmentPermissionBinding
import com.example.archiver.ui.MainActivity
import com.example.archiver.ui.base.BaseFragment
import java.nio.file.Path

class PermissionFragment : BaseFragment<FragmentPermissionBinding>(FragmentPermissionBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val path: String = Environment.getExternalStorageDirectory().path

        binding.matButAgainPermission.setOnClickListener {
            if((requireActivity() as MainActivity).checkPermission()) {
                val path: String = Environment.getExternalStorageDirectory().path
                actionToFileFragment(path)
            } else {
                (requireActivity() as MainActivity).requestPermission()
                if((requireActivity() as MainActivity).checkPermission()) {
                    val path: String = Environment.getExternalStorageDirectory().path
                    actionToFileFragment(path)
                }
            }
        }
    }

    private fun actionToFileFragment(path: String) {
        val action = PermissionFragmentDirections.actionPermissionFragmentToFileFragment(path)
        view?.let { Navigation.findNavController(it).navigate(action) }
    }

    private fun checkPermissionEnabled() {
        if((requireActivity() as MainActivity).checkPermission()) {
            val path: String = Environment.getExternalStorageDirectory().path
            actionToFileFragment(path)
        } else {
            (requireActivity() as MainActivity).requestPermission()
        }
    }

    override fun onStart() {
        super.onStart()
        checkPermissionEnabled()
    }
}