package com.example.navdrawerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.navdrawerapp.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupDrawer()
        setupNavigationView()
    }

    private fun setupDrawer() {
        drawerLayout = binding.drawerLayout
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupNavigationView() {
        binding.navView.apply {
            setNavigationItemSelectedListener {
                it.isChecked
                when (it.itemId) {
                    R.id.home -> replaceFragment(HomeFragment(), it.title.toString())
                    R.id.message -> replaceFragment(MessageFragment(), it.title.toString())
                    R.id.settings -> replaceFragment(SettingsFragment(), it.title.toString())
                    R.id.login -> replaceFragment(LoginFragment(), it.title.toString())
                }
                true
            }
        }
    }

    private fun replaceFragment(fragment: Fragment, title: String) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout1, fragment)
            commit()
        }

        drawerLayout.closeDrawers()
        setTitle(title)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
