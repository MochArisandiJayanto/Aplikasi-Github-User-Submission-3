package com.mrjaya.fundamentalkotlinsubmission3.ui.controller

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mrjaya.fundamentalkotlinsubmission3.ui.setting.SettingPreference

class SettingViewModelFactory(private val pref: SettingPreference) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SettingViewModel::class.java)) {
            return SettingViewModel(pref) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}