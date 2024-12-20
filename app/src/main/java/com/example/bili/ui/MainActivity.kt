package com.example.bili

import RecyclerAdapter
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.bili.adapter.ViewPager2Adapter
import com.example.bili.data.DataSender
import com.example.bili.databinding.ActivityMainBinding
import com.example.bili.model.UpList
import com.example.bili.ui.DetailActivity

class MainActivity : AppCompatActivity(), RecyclerAdapter.OnItemClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewPager2:ViewPager2
    private lateinit var recyclerAdapter: RecyclerAdapter
    private lateinit var viewPager2Adapter: ViewPager2Adapter
    private var upList :MutableList<UpList> = DataSender().onCreateData().toMutableList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = binding.recyclerview
        viewPager2 = binding.viewpager2
        recyclerAdapter = RecyclerAdapter(upList,this)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter = recyclerAdapter
        viewPager2Adapter = ViewPager2Adapter(upList)
        viewPager2.adapter = viewPager2Adapter
    }

    override fun OnItemClick(position: Int) {
        viewPager2.setCurrentItem(position,true)
    }


    override fun OnLongItemClick(position: Int) {
        val intent = Intent(this,DetailActivity::class.java)
        val item = upList[position]
        intent.putExtra("upName",item.id)
        intent.putExtra("avater",item.imageResId)
        startActivityForResult(intent,1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1&&resultCode== RESULT_OK){
            val name = data?.getStringExtra("upName")
            name?.let {removeUP(it)}
        }
    }

    fun removeUP(name:String){
        val index = upList.indexOfFirst { it.id==name }
        if(index>=0){
            upList.removeAt(index)
            recyclerAdapter.notifyItemRemoved(index)
            viewPager2Adapter.notifyItemRemoved(index)
            recyclerAdapter.notifyItemRangeChanged(index,upList.size)
            viewPager2Adapter.notifyItemRangeChanged(index,upList.size)
        }
    }
}
