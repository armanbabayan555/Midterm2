package com.example.midterm2.data

import com.example.midterm2.model.UserModel

class UsersRepo {
    suspend fun getUsers(): List<UserModel> {
        return RetrofitHelper.getInstance().create(MyApiService::class.java).fetchUsers().run {
            this.body()?.usersList?.map {
                UserModel(
                    (it.name.first + " " + it.name.last) ?: "", it.email ?: "", it.nat ?: "",
                )
            } ?: listOf()
        }
    }
}