
package com.example.activitytest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.third_activity.*

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_activity)
        Toast.makeText(this,intent.getStringExtra("extra_data"), Toast.LENGTH_LONG).show()
        button4.setOnClickListener{
            val intent=Intent()
            intent.putExtra("extra_data","end from third to second")
            setResult(RESULT_OK,intent)
            finish()
            }
    }

    override fun onBackPressed() {
        //super.onBackPressed()//这里一定不能继承，因为second里面已经重写了first的onbackpressed函数，这里继承的话，后面的就覆盖掉了
        //https://blog.csdn.net/ai1362425349/article/details/81212023
        val intent=Intent()
        intent.putExtra("extra_data","end from third to second")
        setResult(RESULT_OK,intent)
        finish()
    }

}