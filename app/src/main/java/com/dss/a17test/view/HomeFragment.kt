package com.dss.a17test.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.dss.a17test.HomeViewModel
import com.dss.a17test.R
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }
    private lateinit var listAdapter:UsersRecyclerViewAdapter

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        initView()
        observe()
        viewModel.fetchAgentInfo()
        // TODO: Use the ViewModel
    }
    fun observe(){
        viewModel.userSearchResult.observe(viewLifecycleOwner, {
            listAdapter.updateList(it.items)
        })
    }
    fun initView(){
        listAdapter= UsersRecyclerViewAdapter(arrayListOf())
        usersRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
        }
    }

}