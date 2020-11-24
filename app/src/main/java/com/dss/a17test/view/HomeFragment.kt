package com.dss.a17test.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dss.a17test.viewmodel.HomeViewModel
import com.dss.a17test.R
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : BaseFragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

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
        // TODO: Use the ViewModel

    }
    override
    fun observe(){

    }
    override
    fun initView(){

//        userNameEdt.doAfterTextChanged{
//        }
        searchBtn.setOnClickListener {
            if(userNameEdt.text.toString().isNotEmpty()){
                val name = userNameEdt.text.toString()
                val action =HomeFragmentDirections.actionHomeFragmentToSearchResultFragment(name)
                findNavController().navigate(action)
            }else{
                editTextTextPersonName.error="can't be empty"
            }

        }


    }

}