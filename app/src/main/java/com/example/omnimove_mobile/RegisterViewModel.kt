package com.example.omnimove_mobile


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.omnimove_mobile.data.lokal.AppDatabase
import com.example.omnimove_mobile.data.lokal.UserEntity

class RegisterViewModel(application: Application): AndroidViewModel(application){
    private val appRepository : AppRepository
    private val appDatabase : AppDatabase

    init {
        appDatabase = AppDatabase.getInstance(application)!!
        appRepository = AppRepository(appDatabase)
    }

    suspend fun addUser(userEntity: UserEntity){
        appRepository.addUser(userEntity)
    }

}