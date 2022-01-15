package com.example.activitytest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.second_activity.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        Toast.makeText(this,intent.getStringExtra("extra_data"),Toast.LENGTH_LONG).show()
        button3.setOnClickListener{
            val intent=Intent(this,ThirdActivity::class.java)
            intent.putExtra("extra_data","start to third from second")
            startActivityForResult(intent,2)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //Toast.makeText(this,data?.getStringExtra("extra_data")?:"return nothing",Toast.LENGTH_LONG).show()
        when(requestCode){
            2->if(resultCode== RESULT_OK)
            {
                Toast.makeText(this,data?.getStringExtra("extra_data")?:"return nothing",Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onBackPressed() {
        //super.onBackPressed()
        val intent=Intent()
        intent.putExtra("extra_data","end from second to first")
    }
}