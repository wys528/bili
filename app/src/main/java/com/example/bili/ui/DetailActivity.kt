package com.example.bili.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bili.MainActivity
import com.example.bili.R
import com.example.bili.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailBinding
    private lateinit var avater:ImageView
    private lateinit var idInfo:TextView
    private lateinit var focusInfo:TextView
    private lateinit var followInfo:TextView
    private lateinit var btnUnfollow:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        avater = binding.avater
        idInfo = binding.idInfo
        focusInfo = binding.focusInfo
        followInfo = binding.followInfo
        btnUnfollow = binding.button
        val upName = intent.getStringExtra("upName")
        val image = intent.getIntExtra("avater",0)
        avater.setImageResource(image)
        idInfo.text = upName
        focusInfo.text = "关注:100"
        followInfo.text = "粉丝:100"
        btnUnfollow.setOnClickListener{
            Toast.makeText(applicationContext,"取关成功",Toast.LENGTH_SHORT).show()
            val intent = Intent()
            intent.putExtra("upName",upName)
            setResult(RESULT_OK,intent)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent()
        setResult(RESULT_CANCELED,intent)
    }
}