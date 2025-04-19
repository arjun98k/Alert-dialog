package com.example.customisealertbox

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialogue)
        val btn = findViewById<Button>(R.id.bt1)

        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_shape))

        val btnGood = dialog.findViewById<Button>(R.id.btnGood)
        val button2 = dialog.findViewById<Button>(R.id.button2)

        btnGood.setOnClickListener {
            dialog.dismiss()
        }
        button2.setOnClickListener {
            Toast.makeText(this, "thanks for your feedback", Toast.LENGTH_SHORT).show()
        }
        btn.setOnClickListener {
            dialog.show()
        }

    }
}