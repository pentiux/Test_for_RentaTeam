package ru.narod.pentiux.testforrentateam.presenter.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.narod.pentiux.testforrentateam.R
import ru.narod.pentiux.testforrentateam.databinding.FragmentAboutMyAppBinding

class AboutMyApp : Fragment(R.layout.fragment_about_my_app) {

    private var _binding: FragmentAboutMyAppBinding? = null
    private val binding get() = checkNotNull(_binding) { "AboutMyApp (fragment): _binding isn't initialized" }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentAboutMyAppBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
    }


}