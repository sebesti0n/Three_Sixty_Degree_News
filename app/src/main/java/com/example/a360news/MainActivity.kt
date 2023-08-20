package com.example.a360news

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.a360news.Api.RetrofitInstance
import com.example.a360news.DataClass.Article
import com.example.a360news.DataClass.NewsData
import com.example.a360news.UI.NewsViewModel
import com.example.a360news.adapters.NewsAdapter
import com.example.a360news.adapters.TabviewPagerAdapter
import com.example.a360news.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val api = "b13e655c511147ff873154b2b8ea9b0a"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
         val toolbar:Toolbar=findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

       val viewpager: ViewPager =findViewById(R.id.viewpager)
        val tabs:TabLayout=findViewById(R.id.tabs)
        val adapter = TabviewPagerAdapter(supportFragmentManager)
        viewpager.adapter = adapter
       tabs.setupWithViewPager(viewpager)
//      tabs.addOnTabSelectedListener(object : OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab) {
//                viewpager.currentItem = tab.position
//                if(tab.position in 0..7){
//                    adapter.notifyDataSetChanged()
//                }
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab) {}
//
//
//            override fun onTabReselected(tab: TabLayout.Tab) {
//                TODO("Not yet implemented")
//            }
//
//        })
        viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))

//        val adapter = NewsAdapter()
//
//       rv.layoutManager= LinearLayoutManager(this)
//        rv.adapter=adapter
//        val viewmodel =ViewModelProvider(this)[NewsViewModel::class.java]
//        viewmodel.getbreakingNews()
//         viewmodel.observeNewsLiveData().observe(this) {
//            adapter.setNewsList(it)
//        }

    }
    }

