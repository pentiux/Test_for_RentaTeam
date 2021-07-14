package ru.narod.pentiux.testforrentateam.presenter.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import ru.narod.pentiux.testforrentateam.R
import ru.narod.pentiux.testforrentateam.databinding.FragmentUserCardBinding
import ru.narod.pentiux.testforrentateam.presenter.data.UserListData

class UserCard : Fragment(R.layout.fragment_user_card) {

    private var _binding: FragmentUserCardBinding? = null
    private val binding get() = checkNotNull(_binding) { "AboutMyApp (fragment): _binding isn't initialized" }

    private val args: UserCardArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentUserCardBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
        fillFragment(args.userInfo)
    }

    private fun fillFragment(user: UserListData) = with(binding) {
        //TODO написать загрузку фото
        firstName.text = user.firstName
        lastName.text = user.lastName
        email.text = user.email
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}