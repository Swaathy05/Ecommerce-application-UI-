import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Shop
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.data.DataSource
import com.example.myapplication.data.Item


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemsScreen(navController: NavHostController, category: String) {
    // Load items based on the selected category
    val items = DataSource.loadfreshproduceitem(category)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Items - $category") },
                // Removed navigation icon (Back button)
            )
        },
        bottomBar = {
            BottomAppBar {
                IconButton(
                    onClick = { navController.navigate("start") },
                    modifier = Modifier.padding(horizontal = 30.dp)
                ) {
                    Icon(
                        Icons.Filled.Home,
                        contentDescription = "Home",
                        modifier = Modifier.size(50.dp)
                    )
                }
                IconButton(
                    onClick = { /* Navigate to Cart screen */ },
                    modifier = Modifier.padding(horizontal = 50.dp)
                ) {
                    Icon(
                        Icons.Filled.ShoppingCart,
                        contentDescription = "Cart",
                        modifier = Modifier.size(50.dp)
                    )
                }
                IconButton(
                    onClick = { /* Navigate to Shop */ },
                    modifier = Modifier.padding(horizontal = 26.dp)
                ) {
                    Icon(
                        Icons.Filled.Shop,
                        contentDescription = "Shop",
                        modifier = Modifier.size(50.dp)
                    )
                }
            }
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            ItemList(items) // Pass items list to ItemList
        }
    }
}

@Composable
fun ItemList(items: List<Item>) {
    LazyColumn {
        items(items) { item ->
            ItemCard(item)
        }
    }
}

@Composable
fun ItemCard(item: Item) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Item Image
            Image(
                painter = painterResource(id = item.imageResId),  // Use item.imageResId here
                contentDescription = item.itemQuality,  // Use item.itemQuality here as content description
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp) // Scales to fit the height
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Item Name
            Text(
                text = stringResource(id = item.nameResId), // Use item.nameResId to fetch the name
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Item Details
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = item.itemQuality,  // Display item quality (e.g., "1kg")
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Price: Rs. ${item.itemPrice}",  // Use item.itemPrice for the price
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Add to Cart Button
            Button(
                onClick = { /* Add to cart functionality */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Add to Cart")
            }
        }
    }
}