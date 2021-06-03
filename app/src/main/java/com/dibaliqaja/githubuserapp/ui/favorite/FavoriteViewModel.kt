package com.dibaliqaja.githubuserapp.ui.favorite

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dibaliqaja.githubuserapp.data.local.FavoriteUser
import com.dibaliqaja.githubuserapp.data.local.FavoriteUserDao
import com.dibaliqaja.githubuserapp.data.local.UserDatabase
import com.dibaliqaja.githubuserapp.data.model.DetailUserResponse

class FavoriteViewModel(application: Application): AndroidViewModel(application) {
    val user = MutableLiveData<DetailUserResponse>()

    private var userDao: FavoriteUserDao?
    private var userDb: UserDatabase = UserDatabase.getDatabase(application)!!

    init {
        userDao = userDb.favoriteUserDao()
    }

    fun getFavoriteUser(): LiveData<List<FavoriteUser>>? {
        return userDao?.getFavoriteUser()
    }
}