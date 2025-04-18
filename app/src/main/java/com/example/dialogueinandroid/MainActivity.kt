package com.example.dialogueinandroid

import android.content.DialogInterface
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dialogueinandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.bt1.setOnClickListener {
            val builderset1 = AlertDialog.Builder(this)
            builderset1.setTitle("alert box 1 btn")
            builderset1.setMessage("this is alert box 1")

            builderset1.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, i ->
                finish()
            })
            builderset1.setNegativeButton("No", DialogInterface.OnClickListener { dialog, i ->
                dialog.dismiss()
            })

                builderset1.show()



        }
        binding.bt2.setOnClickListener {
            val builderset2 = AlertDialog.Builder(this)
                .setMessage(" I am happy")
                .setTitle("alert box 2")
            val dialog = builderset2.create()
            dialog.show()

        }
    }
}