package com.example.firebase

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clear.setOnClickListener {
            Name.setText("")
            Password.setText("")
        }
        OK.setOnClickListener {
            val st =Name.text.toString()
            val surname = Password.text.toString()

            val fire = FirebaseDatabase.getInstance()
            val ref = fire.getReference("Employee")
            val id:String? = ref.push().key

            val Employee = Employee(id.toString(),st,surname)

            ref.child(id.toString()).setValue(Employee).addOnCanceledListener {
                Toast.makeText(applicationContext,"Complete", Toast.LENGTH_LONG).show()

            }
            Name.setText("")
            Password.setText("")
        }
    }
}