package com.android.basic.android.component

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.room.util.copy
import com.android.basic.android.R
import com.android.basic.android.ui.theme.BaseTheme
import java.util.logging.Filter


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun ScreenChip() {


    var selected by remember { mutableStateOf(false) }
    var filterSelected by remember { mutableStateOf(false) }
    var assistSelected by remember { mutableStateOf(true) }

    var selectedCategory by remember { mutableStateOf("All") }

    val filteredCoffeeList by remember {
        derivedStateOf {
            if(selectedCategory == "All"){
                coffeeTypes
            }else{
                coffeeTypes.filter { it.name.equals(selectedCategory, ignoreCase = true) }
            }
        }
    }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
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
                        text = "Chips",
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
        ) {
            // Assist chip
            Row() {
                AssistChip(
                    onClick = {
                        assistSelected = !assistSelected
                    },
                    label = {
                        Text(
                            text = "Assist chip"
                        )
                    },
                    leadingIcon = {
                        if (assistSelected) {
                            Icon(
                                painter = painterResource(R.drawable.ic_check_24),
                                contentDescription = null,
                            )
                        }
                    },
                    trailingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_download_24),
                            contentDescription = null,
                        )
                    }
                )
            }
            //InputChip
            Row() {

                InputChip(
                    selected = selected,
                    onClick = {
                        selected = !selected
                    },
                    label = {
                        Text(
                            text = "Input Chip"
                        )
                    },
                    leadingIcon = {
                        if (selected) {
                            Icon(
                                painter = painterResource(R.drawable.ic_check_24),
                                contentDescription = null,
                            )
                        }
                    },
                    trailingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_download_24),
                            contentDescription = null,
                        )
                    },
                    colors = InputChipDefaults.inputChipColors(
                        selectedContainerColor = MaterialTheme.colorScheme.primary,
                        containerColor = MaterialTheme.colorScheme.onPrimary,
                    )
                )
            }
            // SuggestionChip
            Row() {
                SuggestionChip(
                    onClick = {
                    },
                    label = {
                        Text(
                            text = "Suggestion chip"
                        )
                    }
                )
            }
            // FilterChip
            Row() {
                FilterChip(
                    selected = filterSelected,
                    onClick = {
                        filterSelected = !filterSelected
                    },
                    label = {
                        Text(
                            text = "Filter Chip"
                        )
                    },
                    leadingIcon = {
                        if (filterSelected) {
                            Icon(
                                painter = painterResource(R.drawable.ic_check_24),
                                contentDescription = null,
                            )
                        }
                    },
                    trailingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_download_24),
                            contentDescription = null,
                        )
                    },
                    colors = InputChipDefaults.inputChipColors(
                        selectedContainerColor = MaterialTheme.colorScheme.secondary,
                        containerColor = MaterialTheme.colorScheme.onPrimary,
                    )
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
            ) {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    items(categories.size) { index ->

                        val categoryName = categories[index]
                        val isSelected = selectedCategory == categoryName

                        FilterChip(
                            selected = isSelected,
                            onClick = {
                                selectedCategory = categoryName
                            },
                            label = {
                                Text(
                                    text = categoryName
                                )
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = MaterialTheme.colorScheme.onSurface
                            )
                        )
                    }
                }
                LazyHorizontalGrid(
                    rows = GridCells.Fixed(3),
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(filteredCoffeeList.size) { index ->
                        val coffee = filteredCoffeeList[index]

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(120.dp)
                                    .background(Color.LightGray, shape = MaterialTheme.shapes.small)
                            ) {
                                Image(
                                    painter = painterResource(coffee.image),
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                            Text(
                                modifier = Modifier.padding(top = 5.dp),
                                text = coffee.name,
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = false)
@Composable
fun ScreenChipPreview() {
    BaseTheme() {
        ScreenChip()
    }
}

data class CoffeeType(
    val id: Int,
    val name: String,
    @DrawableRes val image: Int,
    val price: Double,
)

val categories: List<String> = listOf(
    "All",
    "Cappuccino",
    "Espresso",
    "Latte",
    "Mocha",
    "Macchiato",
)



val coffeeTypes = listOf<CoffeeType>(
    CoffeeType(1, "Cappuccino", R.drawable.profile_1, 3.5),
    CoffeeType(2, "Espresso", R.drawable.profile_2, 3.0),
    CoffeeType(3, "Latte", R.drawable.profile_3, 3.5),
    CoffeeType(4, "Mocha", R.drawable.profile_4, 4.0),
    CoffeeType(5, "Macchiato", R.drawable.profile_5, 3.5),
    CoffeeType(6, "Cappuccino", R.drawable.profile_6, 3.5),
    CoffeeType(7, "Espresso", R.drawable.profile_7, 3.0),
    CoffeeType(8, "Latte", R.drawable.profile_8, 3.5),
    CoffeeType(9, "Mocha", R.drawable.profile_9, 4.0),
    CoffeeType(10, "Macchiato", R.drawable.profile_10, 3.5),
    CoffeeType(11, "Cappuccino", R.drawable.profile_11, 3.5),
    CoffeeType(12, "Espresso", R.drawable.profile_12, 3.0),
    CoffeeType(13, "Latte", R.drawable.profile_13, 3.5),
    CoffeeType(14, "Mocha", R.drawable.profile_14, 4.0),
    CoffeeType(15, "Macchiato", R.drawable.profile_15, 3.5),
    CoffeeType(16, "Cappuccino", R.drawable.profile_1, 3.5),
    CoffeeType(17, "Espresso", R.drawable.profile_2, 3.0),
    CoffeeType(18, "Latte", R.drawable.profile_3, 3.5),
    CoffeeType(19, "Mocha", R.drawable.profile_4, 4.0),
    CoffeeType(20, "Macchiato", R.drawable.profile_5, 3.5),
)


