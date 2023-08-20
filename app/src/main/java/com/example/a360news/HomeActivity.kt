package com.example.a360news

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a360news.UI.NewsViewModel
import com.example.a360news.adapters.NewsAdapter
import com.example.a360news.databinding.ActivityHomeBinding
import com.example.a360news.databinding.ActivityMainBinding

class HomeActivity:AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    val api = "b13e655c511147ff873154b2b8ea9b0a"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = NewsAdapter()

        binding.Rvhome.layoutManager= LinearLayoutManager(this)
      binding.Rvhome.adapter=adapter
        val viewmodel = ViewModelProvider(this)[NewsViewModel::class.java]
        viewmodel.getbreakingNews()
        viewmodel.observeNewsLiveData().observe(this) {
            adapter.setNewsList(it)
        }

    }
}