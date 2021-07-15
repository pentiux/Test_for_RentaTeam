package ru.narod.pentiux.testforrentateam.presenter.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.android.support.DaggerFragment
import io.reactivex.disposables.Disposable
import ru.narod.pentiux.testforrentateam.R
import ru.narod.pentiux.testforrentateam.databinding.FragmentUserListBinding
import ru.narod.pentiux.testforrentateam.presenter.MainViewModel
import ru.narod.pentiux.testforrentateam.presenter.adapters.UserListAdapter
import ru.narod.pentiux.testforrentateam.presenter.data.*
import javax.inject.Inject

class UserList : DaggerFragment(R.layout.fragment_user_list) {

    private var _binding: FragmentUserListBinding? = null
    private val binding get() = checkNotNull(_binding) { "AboutMyApp (fragment): _binding isn't initialized" }

    @Inject lateinit var vmFactory: ViewModelProvider.Factory
    private val viewModel: MainViewModel by activityViewModels { vmFactory }


    private var _recyclerView: RecyclerView? = null
    private val recyclerView get() = checkNotNull(_recyclerView) {
        "AboutMyApp (fragment): _recyclerView isn't initialized!"
    }

    private lateinit var a : Disposable
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentUserListBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
        val userListAdapter = UserListAdapter { goToUserCard(it) }

        viewModel.uiData.observe(viewLifecycleOwner) { userListAdapter.submitList(it) }
        viewModel.status.observe(viewLifecycleOwner) { checkUserStatus(it) }

        _recyclerView = binding.userListRecycleView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = userListAdapter
        }
    }

    private fun goToUserCard(user: UserListData) {
        if(viewModel.firstCall) {
            val action = UserListDirections.actionUserListToUserCard(user)
            findNavController().navigate(action)
            viewModel.firstCall = false
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun checkUserStatus(status: UserListStatus) = when (status) {
        is UserListLoading -> binding.loadingGif.visibility = View.VISIBLE
        is UserListComplete -> {
            binding.loadingGif.visibility = View.GONE
            binding.errorText.visibility = View.GONE
        }
        is UserListError -> {
            binding.loadingGif.visibility = View.VISIBLE
            binding.errorText.visibility = View.VISIBLE
            binding.loadingGif.setImageDrawable(requireActivity().resources.getDrawable(R.drawable.ic_launcher_foreground))
            binding.errorText.text = status.message
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _recyclerView = null
        _binding = null
    }

}