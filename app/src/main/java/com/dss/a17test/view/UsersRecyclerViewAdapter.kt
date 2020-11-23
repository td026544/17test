package com.dss.a17test.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dss.a17test.R
import com.dss.a17test.model.UserSearchResult

class UsersRecyclerViewAdapter(private val usersData: ArrayList<UserSearchResult.Item>) :RecyclerView.Adapter<UsersRecyclerViewAdapter.ViewHolder>(){
//    var datas = ArrayList<UserSearchResult.Item>()
//
//    init {
//        datas.addAll(usersData)
//    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userNameTxt: TextView

        init {
            // Define click listener for the ViewHolder's View.
            userNameTxt = view.findViewById(R.id.user_name_txt)
        }
    }
    fun updateList(newList: List<UserSearchResult.Item>) {
        usersData.clear()
        usersData.addAll(newList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UsersRecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsersRecyclerViewAdapter.ViewHolder, position: Int) {
//        holder.userNameTxt.text= usersData[position].id.toString()
        holder.userNameTxt.text= position.toString()


    }

    override fun getItemCount(): Int {
        return usersData.size
    }

}