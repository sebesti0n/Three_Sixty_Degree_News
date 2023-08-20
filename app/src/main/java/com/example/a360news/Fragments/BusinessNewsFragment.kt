package com.example.a360news.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a360news.R
import com.example.a360news.UI.NewsViewModel
import com.example.a360news.adapters.NewsAdapter
import com.example.a360news.databinding.FragmentNewsBinding


class BusinessNewsFragment : Fragment() {



    private var _binding: FragmentNewsBinding?=null
    private val binding get()=_binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter= NewsAdapter()
        binding.RVNews.layoutManager= LinearLayoutManager(requireContext())
        binding.RVNews.adapter=adapter
        val viewmodel = ViewModelProvider(this)[NewsViewModel::class.java]
        viewmodel.getCategoryNews("business")
        viewmodel.observeNewsLiveData().observe(requireActivity()) {
            adapter.setNewsList(it)
        }
    }


}