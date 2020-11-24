package com.dss.a17test.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.dss.a17test.R
import com.dss.a17test.viewmodel.SearchResultViewModel
import com.orhanobut.logger.Logger.d
import kotlinx.android.synthetic.main.search_result_fragment.*

class SearchResultFragment : BaseFragment() {
    private  val args: SearchResultFragmentArgs by navArgs()

    companion object {
        fun newInstance() = SearchResultFragment()
    }

    private lateinit var viewModel: SearchResultViewModel
    private lateinit var listAdapter:UsersRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_result_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SearchResultViewModel::class.java)

        viewModel.searchUser(args.name)
        initView()
        observe()

        // TODO: Use the ViewModel
    }

    override fun initView() {
        listAdapter= UsersRecyclerViewAdapter(requireContext())
        usersRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
        }
        requireActivity().title = "Search "+args.name+" Result"

    }

    override fun observe() {
        viewModel.userItems.observe(viewLifecycleOwner, {
            listAdapter.submitList(it) {
            }


        })
    }


}