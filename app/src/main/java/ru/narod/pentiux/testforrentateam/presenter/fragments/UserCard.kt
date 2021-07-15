package ru.narod.pentiux.testforrentateam.presenter.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import dagger.android.support.DaggerFragment
import ru.narod.pentiux.testforrentateam.R
import ru.narod.pentiux.testforrentateam.databinding.FragmentUserCardBinding
import ru.narod.pentiux.testforrentateam.presenter.MainViewModel
import ru.narod.pentiux.testforrentateam.presenter.data.UserListData
import javax.inject.Inject

class UserCard : DaggerFragment(R.layout.fragment_user_card) {

    private var _binding: FragmentUserCardBinding? = null
    private val binding get() = checkNotNull(_binding) { "AboutMyApp (fragment): _binding isn't initialized" }

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory
    private val viewModel: MainViewModel by activityViewModels { vmFactory }

    private val args: UserCardArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentUserCardBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
        fillFragment(args.userInfo)
        loadImg(args.userInfo.avatarUrl)
        viewModel.firstCall = true
    }

    private fun fillFragment(user: UserListData) = with(binding) {
        firstName.text = user.firstName
        lastName.text = user.lastName
        email.text = user.email
    }

    private fun loadImg(url: String) =
        Picasso.get()
            .load(url)
            .fit()
            .placeholder(R.drawable.ic_channel_background)
            .error(R.drawable.ic_channel_foreground)
            .into(binding.avatarImg)

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}