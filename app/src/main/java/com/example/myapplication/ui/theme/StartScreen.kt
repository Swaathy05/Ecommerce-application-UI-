package com.example.myapplication.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.TrackChanges
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.data.DataSource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(
    flashViewModel: Flashviewmodel,
    onCategoriesClicked: (String) -> Unit
) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Welcome to Buyzy") },
                actions = {
                    Text(
                        text = "Login",
                        color = Color.Black,
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .clickable {
                                Toast.makeText(context, "Login Clicked", Toast.LENGTH_SHORT).show()
                            }
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFA39F9F))
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFFA39F9F),
                content = {
                    IconButton(onClick = { Toast.makeText(context, "Home Clicked", Toast.LENGTH_SHORT).show() }) {
                        Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.Black)
                    }
                    Spacer(modifier = Modifier.weight(1f, true))
                    IconButton(onClick = { Toast.makeText(context, "Cart Clicked", Toast.LENGTH_SHORT).show() }) {
                        Icon(Icons.Default.ShoppingCart, contentDescription = "Cart", tint = Color.Black)
                    }
                    Spacer(modifier = Modifier.weight(1f, true))
                    IconButton(onClick = { Toast.makeText(context, "Track Your Purchase Clicked", Toast.LENGTH_SHORT).show() }) {
                        Icon(Icons.Default.TrackChanges, contentDescription = "Track Your Purchase", tint = Color.Black)
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).background(Color(0xFFFFFFFF))) {
            Image(
                painter = painterResource(id = R.drawable.newyearsale2), // Replace with your sale banner image resource
                contentDescription = "Sale Banner",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(1.dp)
            )
            Text(
                text = "Categories",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
            )
            LazyVerticalGrid(
                columns = GridCells.Adaptive(128.dp),
                contentPadding = PaddingValues(5.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.wrapContentSize()
            ) {
                items(DataSource.loadCategories()) {
                    CategoryCard(
                        context = context,
                        stringResourceId = it.stringResourceId,
                        imageResourceId = it.imageResourceId,
                        onCategoriesClicked = onCategoriesClicked
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryCard(
    context: Context,
    stringResourceId: Int,
    imageResourceId: Int,
    onCategoriesClicked: (String) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        val categoryName = context.getString(stringResourceId)
        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFFC5C3C3)),
            modifier = Modifier.clickable {
                Toast.makeText(context, "You have clicked $categoryName", Toast.LENGTH_SHORT).show()
                onCategoriesClicked(categoryName)
            }
        ) {
            Column(
                modifier = Modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = imageResourceId),
                    contentDescription = null,
                    modifier = Modifier.wrapContentSize()
                )
                Text(
                    text = context.getString(stringResourceId),
                    color = Color.Black,
                    fontSize = 23.sp,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
        }
    }
}
