package com.example.archiver.ui

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.archiver.R

class MainActivity : AppCompatActivity() {
//    private var _binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun checkPermission(): Boolean {
        val result: Int = ContextCompat
            .checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)

        return result == PackageManager.PERMISSION_GRANTED
    }

    fun requestPermission() {

        if(ActivityCompat
                .shouldShowRequestPermissionRationale(
                    this,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(baseContext, "Good", Toast.LENGTH_SHORT).show()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), 111
            )
            Toast.makeText(this, "запросик", Toast.LENGTH_SHORT).show()

        }
    }
}