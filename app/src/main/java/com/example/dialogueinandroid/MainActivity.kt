package com.example.dialogueinandroid

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
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
        binding.bt3.setOnClickListener{
            val builderset3 = AlertDialog.Builder(this)
                .setTitle("fruits item")
                .setPositiveButton("Positive"){dialog, which -> finish()}
                .setNegativeButton("Negative"){dialog, which ->}
                .setNeutralButton("Neutral"){dialog, which ->}
                .setItems(arrayOf("apple","banana","orange")){dialog, which -> }
            val dialog: AlertDialog = builderset3.create()
            dialog.show()
        }
        binding.bt4.setOnClickListener {
            val builderset4 = AlertDialog.Builder(this)
                .setTitle("alert box 4")
                .setPositiveButton("Positive"){dialog, which ->
                    Toast.makeText(
                        this,
                        "you click on positive",
                        Toast.LENGTH_SHORT
                    ).show()}
                .setNegativeButton("Negative"){dialog, which ->}
                .setSingleChoiceItems(arrayOf("hacker","nontechy","teacher"),0){dialog, which ->}

            val dialog: AlertDialog = builderset4.create()
            dialog.show()
        }

    }
}