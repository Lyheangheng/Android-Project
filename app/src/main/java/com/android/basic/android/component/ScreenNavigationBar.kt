package com.android.basic.android.component


import android.app.Dialog
import android.content.Context
import android.provider.ContactsContract
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.basic.android.R
import com.android.basic.android.ui.theme.BaseTheme
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.Popup
import com.android.basic.android.functions.RatingBar
import com.android.basic.android.model.clothesList
import com.android.basic.android.storage.productLists
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.nio.file.WatchEvent
import kotlin.collections.chunked


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun ScreenNavigationBar() {


    data class NavigationItemsList(
        val id: Int,
        @DrawableRes val icon: Int,
        val label: String
    )

    var selectedNavigationItem by remember { mutableIntStateOf(0) }

    val navigationItemsList = remember {
        mutableListOf(
            NavigationItemsList(
                id = 1,
                icon = R.drawable.baseline_home_24,
                label = "Home"
            ),
            NavigationItemsList(
                id = 2,
                icon = R.drawable.ic_festival_24,
                label = "Profile"
            ),
            NavigationItemsList(
                id = 3,
                icon = R.drawable.ic_settings_24,
                label = "Setting"
            ),
        )
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    Icon(
                        tint = MaterialTheme.colorScheme.outline,
                        painter = painterResource(R.drawable.ic_sort_24),
                        contentDescription = null
                    )
                },
                title = {
                    Text(
                        color = MaterialTheme.colorScheme.outline,
                        text = "Bottom Navigation Bar",
                        fontWeight = FontWeight.ExtraBold
                    )
                },
                actions = {
                    BadgedBox(
                        badge = {
                            Badge(
                                containerColor = MaterialTheme.colorScheme.outline
                            )
                        }
                    )
                    {
                        Icon(
                            tint = MaterialTheme.colorScheme.outline,
                            painter = painterResource(R.drawable.ic_baseline_notifications_none_24),
                            contentDescription = null,
                        )
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar(
            ) {

                navigationItemsList.forEachIndexed { index, item ->
                    NavigationBarItem(
                        colors = NavigationBarItemDefaults.colors(
                             indicatorColor = MaterialTheme.colorScheme.outline,
                            selectedTextColor = MaterialTheme.colorScheme.inversePrimary,
                            selectedIconColor = MaterialTheme.colorScheme.background,
                        ),
                        selected = index == selectedNavigationItem,
                        onClick = {
                            selectedNavigationItem = index
                        },
                        icon = {
                            Icon(
                                painter = painterResource(item.icon),
                                contentDescription = null,
                            )
                        },
                        label = {
                            Text(
                                text = item.label
                            )
                        }
                    )
                }

            }
        }
    )
    { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (selectedNavigationItem) {
                0 -> {
                    HomeScreen()
                }

                1 -> {
                    SearchScreen()
                }

                2 -> {
                    ProfileScreen()
                }
            }
        }
    }
}


@Preview(showBackground = false)
@Composable
fun ScreenNavigationBarPreview() {
    BaseTheme() {
        ScreenNavigationBar()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

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
    val filteredProducts = remember(selectedCategory , shuffledProducts){
        if(selectedCategory == "All"){
            shuffledProducts
        }else{
            shuffledProducts.filter { it.category.equals(selectedCategory, ignoreCase = true) }
        }
    }


    Scaffold(
        modifier = Modifier,

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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen() {


    var showDatePicker by remember { mutableStateOf(false) }

    val datePickerState = rememberDatePickerState()
    val selectedDate = datePickerState.selectedDateMillis?.let {
        convertMillisToDate(it, DateTimeFormatPattern.dd_mmm_yyyy_hh_mm.format)
    } ?: ""

    LaunchedEffect(selectedDate) {
        println("Selected date: $selectedDate")
    }


    Scaffold(
        modifier = Modifier.fillMaxSize(),

    )
    { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Selected date: $selectedDate"
            )
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (showDatePicker) {
                    Popup(
                        onDismissRequest = {
                            showDatePicker = false
                        }
                    ) {
                        DatePicker(
                            modifier = Modifier
                                .padding(12.dp)
                                .clip(RoundedCornerShape(12.dp)),
                            state = datePickerState
                        )
                    }
                }
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    Scaffold(
        modifier = Modifier,
    ) { padding ->
        LazyVerticalGrid(
            modifier = Modifier
                .padding(padding),
            columns = GridCells.Fixed(2)
        ) {
            items(clothesList.size){ index ->
                val cloth = clothesList[index]
                // Image
                Column(
                    modifier = Modifier
                        .padding(5.dp)
                        .safeContentPadding()
//                        .background(color = Color.LightGray)
                ) {
                    // Image
                    Box(
                        modifier = Modifier
                            .height(180.dp)
                    )
                    {
                        Image(
                            modifier = Modifier
                                .fillMaxSize(),
                            contentScale = ContentScale.Crop,
                            painter = painterResource(id = cloth.image),
                            contentDescription = "Clothes"
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    // Description
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = cloth.description,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1
                        )
                    }
                    //Price and Add to cart btn
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${cloth.clothesCurrencyCode.code}${cloth.price}",
                            color = Color.Red,
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        FilledTonalButton(
                            modifier = Modifier,
                            onClick = {},
                            contentPadding = PaddingValues(0.dp),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.Black,
                                containerColor = Color.White
                            ),
                            border = BorderStroke(1.dp, Color.Black)
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(15.dp),
                                painter = painterResource(R.drawable.add_shop_cart),
                                contentDescription = null,
                                tint = Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}