package com.example.midterm2.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.midterm2.model.UserModel

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel.loadUsers()

        setContent {
            Column {
                TopPart()
                UserList(mainViewModel)
            }
        }
    }
}

@Composable
fun TopPart() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
    ) {
        Text(
            text = "USERS",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h2
        )
    }
}


@Composable
fun UserList(mainViewModel: MainViewModel) {
    val usersList by mainViewModel.usersList.observeAsState(emptyList())
    LazyColumn {
        items(usersList) { user ->
            UserItem(user)
        }
    }
}

@Composable
fun UserItem(user: UserModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .border(0.5.dp, Color.Black)
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = user.name)
            Text(text = user.email)
        }
        Text(text = user.nat)
    }

}
