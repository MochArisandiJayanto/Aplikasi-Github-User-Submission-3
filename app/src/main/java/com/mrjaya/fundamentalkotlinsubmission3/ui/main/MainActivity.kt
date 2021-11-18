package com.mrjaya.fundamentalkotlinsubmission3.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import com.mrjaya.fundamentalkotlinsubmission3.databinding.ActivityMainBinding
import com.mrjaya.fundamentalkotlinsubmission3.ui.controller.SettingViewModel
import com.mrjaya.fundamentalkotlinsubmission3.ui.controller.SettingViewModelFactory
import com.mrjaya.fundamentalkotlinsubmission3.ui.home.HomeActivity
import com.mrjaya.fundamentalkotlinsubmission3.ui.setting.SettingPreference
import com.mrjaya.fundamentalkotlinsubmission3.ui.setting.dataStore

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val pref = SettingPreference.getInstance(dataStore)
        val settingViewModel = ViewModelProvider(this, SettingViewModelFactory(pref)).get(
            SettingViewModel::class.java
        )
        settingViewModel.getThemeSettings().observe(this,
            { isDarkModeActive: Boolean ->
                if (isDarkModeActive) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
            })

        setContentView(binding.root)

        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            val homeIntent = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(homeIntent)
            finish()
        }, 3000)
    }
}