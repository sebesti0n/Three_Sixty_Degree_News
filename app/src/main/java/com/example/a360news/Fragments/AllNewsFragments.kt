package com.example.a360news.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a360news.Api.RetrofitInstance
import com.example.a360news.DataClass.Article
import com.example.a360news.DataClass.NewsData
import com.example.a360news.UI.NewsViewModel
import com.example.a360news.adapters.NewsAdapter
import com.example.a360news.databinding.FragmentNewsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AllNewsFragments : Fragment() {


    private var _binding: FragmentNewsBinding?=null
    private val binding get()=_binding!!
    val api = "b13e655c511147ff873154b2b8ea9b0a"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding=FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter=NewsAdapter()
        binding.RVNews.layoutManager=LinearLayoutManager(requireContext())
        binding.RVNews.adapter=adapter
        val viewmodel = ViewModelProvider(this)[NewsViewModel::class.java]
        viewmodel.getbreakingNews()
        viewmodel.observeNewsLiveData().observe(requireActivity()) {
            adapter.setNewsList(it)
        }
    }
    }


