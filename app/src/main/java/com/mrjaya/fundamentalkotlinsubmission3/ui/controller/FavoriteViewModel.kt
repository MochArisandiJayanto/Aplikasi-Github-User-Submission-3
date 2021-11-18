package com.mrjaya.fundamentalkotlinsubmission3.ui.controller

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mrjaya.fundamentalkotlinsubmission3.database.FavoriteUser
import com.mrjaya.fundamentalkotlinsubmission3.database.FavoriteUserDao
import com.mrjaya.fundamentalkotlinsubmission3.database.FavoriteUserRoomDatabase

class FavoriteViewModel(application: Application) : ViewModel() {
    private val mFavoriteUserDao: FavoriteUserDao

    init {
        val db = FavoriteUserRoomDatabase.getDatabase(application)
        mFavoriteUserDao = db.favoriteUserDao()
    }

    fun getAllFavoriteUser(): LiveData<List<FavoriteUser>> = mFavoriteUserDao.getFavoriteUser()
}