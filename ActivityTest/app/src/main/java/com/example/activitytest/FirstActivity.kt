package com.example.activitytest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.first_layout.*

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)
        val button1:Button=findViewById(R.id.button1)//findViewById返回值为view的泛型,无法自动推断具体类型,要显示声明类型如Button
        button1.setOnClickListener({Toast.makeText(this,"hello clicker",Toast.LENGTH_SHORT).show()})
        //PS:这里的button1可以直接使用，不需要声明，只要在app下的build.gradle中引用了kotlin-android-extensions这个库即可
        //相当于引用了这个库就会自动帮你在代码里声明变量,如果有好多好多个控件,就不需要一个一个findViewById了

        //intent.addCategory("MY_CATEGORY")
        button2.setOnClickListener{
            val intent=Intent(this,SecondActivity::class.java)
            intent.putExtra("extra_data","start to second from first")
            startActivityForResult(intent,1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            1->if(resultCode== RESULT_OK){
                Toast.makeText(this,data?.getStringExtra("extra_data")?:"return nothing",Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)//menuInflater是创建一个menu，相当于kotlin自动调用了父类的getmenuInflater，是一个语法糖
        //inflate是创建菜单的函数,第一个参数是使用的menu资源文件,第二个参数是在哪个Menu类上创建菜单,这里使用的是这个函数onCreateOptionsMenu传入的参数menu
        return true//返回true表示显示菜单,返回false表示不显示菜单
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){//when类似于c里面的switch，item.itemId也是上述语法糖，内部调用了getItemId函数
            R.id.add_item->Toast.makeText(this,"You clicked Add",Toast.LENGTH_SHORT).show()
            R.id.remove_item->Toast.makeText(this,"You clicked Remove",Toast.LENGTH_SHORT).show()
            //when的写法:  when(a){
        // b -> do sth   表示当a==b时,做 sth
        // c -> do other th  表示当a==c时,做other th
        // }
        }
        return true//这个函数用于选择每个菜单项被点击时发生什么,返回true时函数有效
    }
}