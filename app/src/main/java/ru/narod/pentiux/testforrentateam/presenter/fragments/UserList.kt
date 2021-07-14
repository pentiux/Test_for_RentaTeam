package ru.narod.pentiux.testforrentateam.presenter.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.narod.pentiux.testforrentateam.R
import ru.narod.pentiux.testforrentateam.databinding.FragmentUserListBinding
import ru.narod.pentiux.testforrentateam.presenter.UserListAdapter
import ru.narod.pentiux.testforrentateam.presenter.data.UserListData

class UserList : Fragment(R.layout.fragment_user_list) {

    private var _binding: FragmentUserListBinding? = null
    private val binding get() = checkNotNull(_binding) { "AboutMyApp (fragment): _binding isn't initialized" }

    private var _recyclerView: RecyclerView? = null
    private val recyclerView get() = checkNotNull(_recyclerView) {
        "AboutMyApp (fragment): _recyclerView isn't initialized!"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentUserListBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

        val userListAdapter = UserListAdapter { goToUserCard(it) }.apply {
            submitList( // TODO написать загрузку списка из БД
                listOf(
                    UserListData.getRandomData(),
                    UserListData.getRandomData(),
                    UserListData.getRandomData(),
                    UserListData.getRandomData(),
                    UserListData.getRandomData(),
                    UserListData.getRandomData())
            )
        }
        _recyclerView = binding.userListRecycleView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = userListAdapter
        }
    }

    private fun goToUserCard(user: UserListData) {
        val action = UserListDirections.actionUserListToUserCard(user)
        findNavController().navigate(action)
    }

    override fun onDestroy() {
        super.onDestroy()
        _recyclerView = null
        _binding = null
    }
}