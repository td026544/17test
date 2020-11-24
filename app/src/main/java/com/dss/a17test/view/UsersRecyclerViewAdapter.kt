package com.dss.a17test.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.dss.a17test.R
import com.dss.a17test.model.UserSearchResult

class UsersRecyclerViewAdapter(val context: Context):
    PagedListAdapter<UserSearchResult.Item, UsersRecyclerViewAdapter.ViewHolder>(DiffCallback){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userNameTxt: TextView = view.findViewById(R.id.user_name_txt)
        val userAvatar: ImageView = view.findViewById(R.id.user_avatar)


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UsersRecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val data = getItem(position)

        data?.let {
            holder.userNameTxt.text=data.login
            val avatarUrl=data.avatar_url

                Glide.with(context)
                .load(avatarUrl)
                    .error(R.drawable.ic_baseline_error_24)
                    .placeholder(R.drawable.ic_baseline_person_24)
                    .into(holder.userAvatar);

        }


    }





    companion object DiffCallback : DiffUtil.ItemCallback<UserSearchResult.Item>() {



        override fun areItemsTheSame(
            oldItem: UserSearchResult.Item,
            newItem: UserSearchResult.Item
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: UserSearchResult.Item,
            newItem: UserSearchResult.Item
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }


}