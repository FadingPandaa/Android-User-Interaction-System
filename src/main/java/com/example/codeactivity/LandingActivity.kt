package com.example.codeactivity

import android.os.Bundle
import android.widget.ImageView
import android.widget.EditText
import android.widget.Button
import android.content.Intent
import android.widget.TextView
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LandingActivity : AppCompatActivity() {

    //declaring variables
    private lateinit var hello_text: TextView
    private lateinit var editName: editName
    private lateinit var btn_Thanks: btn_Thanks


    //creating reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_landing)

        //getting references for our views
        hello_text = findViewById<TextView>(R.id.hello_text)
        editName = findViewById<EditText>(R.id.editName)
        btn_Thanks = findViewById<Button>(R.id.btn_Thanks)

        btn_Thanks.setOnClickListerner{
            val name = editName.text.toString().trim()
            hello_text.text = if (name.isEmpty()){
                getString(R.string.hello_text)
            }else{
                "hello $name, welcome"
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}