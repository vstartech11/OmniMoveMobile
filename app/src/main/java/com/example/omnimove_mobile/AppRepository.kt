package com.example.omnimove_mobile

import com.example.omnimove_mobile.data.lokal.UserEntity
import com.example.omnimove_mobile.data.lokal.AppDatabase



class AppRepository (private val database: AppDatabase){
    suspend fun addUser(user: UserEntity){
        database.userDao().addUser(user)
    }
}