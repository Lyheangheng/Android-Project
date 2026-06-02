package com.android.basic.android.component.homework

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.basic.android.R
import com.android.basic.android.functions.RatingBar
import com.android.basic.android.storage.productLists

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeworkOnlineShopHomePage() {

    val scrollState = rememberScrollState()
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    var selectedCategory by remember { mutableStateOf("All") }
    val chipItems = listOf(
        "All",
        "hat",
        "pants",
        "Dress",
        "Shirt",
        "Accessories",
        "Jacket",
        "shorts"
    )

    val shuffledProducts = remember { productLists.shuffled() }
    val filteredProducts = remember(selectedCategory ){
        if(selectedCategory == "All"){
            shuffledProducts
        }else{
            productLists.filter { it.category.equals(selectedCategory, ignoreCase = true) }
        }
    }


    Scaffold(
        modifier = Modifier,
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_sort_24),
                        contentDescription = null
                    )
                },
                title = {
                    Text(
                        text = "STYLLA FASHION",
                        fontWeight = FontWeight.ExtraBold
                    )
                },
                actions = {
                    BadgedBox(
                        badge = {
                            Badge()
                        }
                    )
                {
                    Icon(
                        painter = painterResource(R.drawable.ic_baseline_notifications_none_24),
                        contentDescription = null,
                    )
                }

                },
            )
        }
    )
    { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(scrollState)
                .background(color = Color.LightGray.copy(alpha = 0.3f))
        ) {

            Column() {
                // Search Bar
                    DockedSearchBar(
                        modifier = Modifier.fillMaxWidth()
                            .padding(start = 12.dp, end = 12.dp, top = 12.dp),
                        inputField = {
                            SearchBarDefaults.InputField(
                                query = query,
                                onQueryChange = { query = it },
                                onSearch = { active = false },
                                expanded = active,
                                onExpandedChange = { active = it },
                                placeholder = { Text("Search...") }
                            )
                        },
                        expanded = active,
                        onExpandedChange = { active = it }
                    ) {}
                    // Chip Selection
                    LazyRow(
                        modifier = Modifier
                            .padding(12.dp)
                    ) {
                        items(chipItems.size) { index ->
                            val name = chipItems[index]
                            FilterChip(
                                modifier = Modifier.padding(end = 8.dp),
                                selected = (name == selectedCategory),
                                onClick = { selectedCategory = name },
                                label = { Text(name) },
                                shape = RoundedCornerShape(50)
                            )
                        }
                    }
                    //  Card Products
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp)
                    ) {
                        for (product in filteredProducts.chunked(2)) {
                            // Product Image
                            Row(
                                modifier = Modifier.padding(bottom = 12.dp)
                            ) {
                                //first product
                                val firstProduct = product[0]
                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 6.dp)
                                ) {
                                    Card(
                                        colors = CardDefaults.cardColors(
                                            containerColor = MaterialTheme.colorScheme.surface
                                        ),
                                        modifier = Modifier,
                                    ) {
                                        Image(
                                            painter = painterResource(firstProduct.image),
                                            contentDescription = null,
                                            modifier = Modifier.size(200.dp),
                                            contentScale = ContentScale.FillBounds
                                        )
                                        Column(modifier = Modifier.padding(16.dp)) {
                                            Text(text = firstProduct.description)
                                            RatingBar(firstProduct.rating)
                                            Text(text = "${firstProduct.currencyCodeSymbol.symbol} ${firstProduct.price}")
                                        }
                                    }
                                }
                                // second product
                                if (product.size > 1) {
                                    val secondProduct = product[1]
                                    Column(
                                        modifier = Modifier
                                            .weight(1f)
                                            .padding(start = 6.dp)
                                    ) {
                                        Card(
                                            colors = CardDefaults.cardColors(
                                                containerColor = MaterialTheme.colorScheme.surface
                                            ),
                                            modifier = Modifier,
                                        ) {
                                            Image(
                                                painter = painterResource(secondProduct.image),
                                                contentDescription = null,
                                                modifier = Modifier.size(200.dp),
                                                contentScale = ContentScale.FillBounds
                                            )
                                            Column(modifier = Modifier.padding(16.dp)) {
                                                Text(text = secondProduct.description)
                                                RatingBar(secondProduct.rating)
                                                Text(text = "${secondProduct.currencyCodeSymbol.symbol} ${secondProduct.price}")
                                            }
                                        }
                                    }
                                } else {
                                    Spacer(modifier = Modifier.weight(1f))
                                }
                            }
                        }
                    }
                }
            }
        }
    }


@Preview(showBackground = false)
@Composable
fun HomeworkOnlineShopHomePagePreview() {

    HomeworkOnlineShopHomePage()

}