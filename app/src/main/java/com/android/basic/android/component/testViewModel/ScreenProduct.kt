package com.android.basic.android.component.testViewModel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.android.basic.android.R
import com.android.basic.android.model.ProductListViewModel
import com.android.basic.android.repository.test.Product
import coil3.compose.AsyncImage
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.tooling.preview.Preview
import com.android.basic.android.ui.theme.BaseTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(
    viewModel: ProductListViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Products",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                },
                navigationIcon = {
                    Icon(
                        painterResource(R.drawable.ic_sort_24),
                        null,
                    )
                },
                actions = {
                    Icon(
                        painterResource(R.drawable.ic_baseline_notifications_none_24),
                        null,
                    )
                }
            )

        },
        bottomBar = {
            BottomAppBar (
                actions = {
                    HorizontalToolBar()
                },
                floatingActionButton = {
                    FloatingActionButton(
                        elevation = FloatingActionButtonDefaults.elevation(
                            defaultElevation = 8.dp,
                        ),
                        containerColor = MaterialTheme.colorScheme.background,
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_call_end_24),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Text(
                text = "Products",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            SearchBar(
                query = uiState.searchQuery,
                onQueryChange = viewModel::onSearchQueryChange
            )

            Spacer(modifier = Modifier.height(12.dp))

            when {
                uiState.isLoading -> LoadingIndicator()
                uiState.errorMessage != null -> ErrorMessage(
                    message = uiState.errorMessage!!,
                    onRetry = viewModel::loadProducts,
                    onDismiss = viewModel::dismissError
                )

                uiState.filteredProducts.isEmpty() -> EmptyState()
                else -> ProductList(products = uiState.filteredProducts)
            }
        }

    }


}

@Composable
fun HorizontalToolBar(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier
                .height(60.dp),
            shape = RoundedCornerShape(32.dp),
            tonalElevation = 2.dp,
            shadowElevation = 8.dp,
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {

                IconButton(onClick = {}) {
                    Icon(
                        painterResource(id = R.drawable.ic_videocam_off_24),
                        contentDescription = null
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        painterResource(id = R.drawable.ic_mic_24),
                        contentDescription = null
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        painterResource(id = R.drawable.ic_front_hand_24),
                        contentDescription = null
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        painterResource(id = R.drawable.more_vert),
                        contentDescription = null
                    )
                }

            }
        }
    }
}

@Composable
private fun SearchBar(query: String, onQueryChange: (String) -> Unit) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text("Search products...") },
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_search_24),
                contentDescription = null
            )
        },
        singleLine = true,
        shape = RoundedCornerShape(12.dp)
    )
}

@Composable
private fun ProductList(products: List<Product>) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        items(products, key = { it.id }) { product ->
            ProductCard(product = product)
        }
    }
}

@Composable
private fun ProductCard(product: Product) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = product.imageUrl,
                contentDescription = product.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = product.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "$${product.price}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
private fun LoadingIndicator() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
private fun ErrorMessage(message: String, onRetry: () -> Unit, onDismiss: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = message, color = MaterialTheme.colorScheme.error)
        Spacer(modifier = Modifier.height(12.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedButton(onClick = onDismiss) { Text("Dismiss") }
            Button(onClick = onRetry) { Text("Retry") }
        }
    }
}

@Composable
private fun EmptyState() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("No products found.", color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}

@Composable
@Preview(showBackground = false)
fun ScreenProductPreview() {
    BaseTheme {
        ProductListScreen()
    }
}