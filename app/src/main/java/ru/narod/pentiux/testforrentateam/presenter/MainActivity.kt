package ru.narod.pentiux.testforrentateam.presenter

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.support.DaggerAppCompatActivity
import ru.narod.pentiux.testforrentateam.R
import ru.narod.pentiux.testforrentateam.databinding.ActivityMainBinding

class MainActivity : DaggerAppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = checkNotNull(_binding) { "MainActivity: _binding isn't initialized!" }
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }

        val navView: BottomNavigationView = binding.bottomNavView
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.main_fragment_container) as NavHostFragment
        navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.userList, R.id.aboutMyApp)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp() =
        navController.navigateUp() || super.onSupportNavigateUp()
}