package ru.narod.pentiux.testforrentateam.presenter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.narod.pentiux.testforrentateam.databinding.UserItemLayoutBinding
import ru.narod.pentiux.testforrentateam.presenter.data.UserListData

class UserListAdapter (
    private val onItemClicked: (UserListData) -> Unit
): ListAdapter<UserListData, UserListAdapter.UserListViewHolder>(DiffCallback) {

    companion object DiffCallback: DiffUtil.ItemCallback<UserListData>() {
        override fun areItemsTheSame(
            oldItem: UserListData,
            newItem: UserListData
        ) = oldItem === newItem

        override fun areContentsTheSame(
            oldItem: UserListData,
            newItem: UserListData
        ) = oldItem == newItem
    }

    class UserListViewHolder(private val binding: UserItemLayoutBinding )
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: UserListData) = binding.apply {
            userItemListFirstName.text = user.firstName
            userItemListLastName.text = user.lastName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val viewHolder = UserListViewHolder(
            UserItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        viewHolder.itemView.setOnClickListener {
            onItemClicked(getItem(viewHolder.adapterPosition))
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}