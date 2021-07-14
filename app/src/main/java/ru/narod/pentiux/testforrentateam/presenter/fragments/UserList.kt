package ru.narod.pentiux.testforrentateam.presenter.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.narod.pentiux.testforrentateam.R
import ru.narod.pentiux.testforrentateam.databinding.FragmentUserListBinding

class UserList : Fragment(R.layout.fragment_user_list) {

    private var _binding: FragmentUserListBinding? = null
    private val binding get() = checkNotNull(_binding) { "AboutMyApp (fragment): _binding isn't initialized" }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentUserListBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
    }

}