package com.example.midterm2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.midterm2.data.UsersRepo
import com.example.midterm2.model.UserModel
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    private val _users: MutableLiveData<List<UserModel>> = MutableLiveData()
    val usersList: LiveData<List<UserModel>> = _users


    fun loadUsers() {
        viewModelScope.launch {
            _users.postValue(UsersRepo().getUsers())
        }
    }
}