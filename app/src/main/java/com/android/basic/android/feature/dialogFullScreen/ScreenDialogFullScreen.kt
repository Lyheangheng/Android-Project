package com.android.basic.android.feature.dialogFullScreen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.basic.android.R
import com.android.basic.android.ui.theme.BaseTheme
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun ScreenDialogFullScreen(onBack: () -> Unit = {}) {

    var isDialogOpen by remember { mutableStateOf(false) }

    if (isDialogOpen) {
        Dialog(
            onDismissRequest = { isDialogOpen = false },
            properties = DialogProperties(
                usePlatformDefaultWidth = false
            )
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    // close button
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        IconButton(
                            onClick = {
                                isDialogOpen = false
                            }
                        ) {
                            Icon(
                                tint = MaterialTheme.colorScheme.outline,
                                painter = painterResource(R.drawable.ic_cancel_24),
                                contentDescription = null,
                            )
                        }
                    }
                    // Dialog content
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .verticalScroll(rememberScrollState())
                            .padding(16.dp),
                    ) {
                        invoiceSections.forEach { (title, items) ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(color = MaterialTheme.colorScheme.outline)
                                    .padding(top = 6.dp, bottom = 6.dp),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    color = MaterialTheme.colorScheme.background,
                                    fontWeight = FontWeight.Bold,
                                    text = title
                                )
                            }
                            items.forEach { (label, value) ->
                                Row(
                                    modifier = Modifier.padding(top = 5.dp)
                                ) {
                                    Text(
                                        color = MaterialTheme.colorScheme.inversePrimary,
                                        text = label
                                    )
                                    Spacer(modifier = Modifier.weight(1f))
                                    Text(
                                        color = MaterialTheme.colorScheme.inversePrimary,
                                        text = value
                                    )
                                }
                                HorizontalDivider()
                            }
                        }
                    }
                    // confirm button
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.outline,
                            ),
                            modifier = Modifier
                                .padding(16.dp),
                            onClick = {
                                isDialogOpen = false
                            }
                        ) {
                            Text(text = "confirm")
                        }
                    }
                }
            }
        }
    }



    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            tint = MaterialTheme.colorScheme.outline,
                            painter = painterResource(R.drawable.baseline_arrow_back_ios_new_24),
                            contentDescription = null
                        )
                    }
                },
                title = {
                    Text(
                        color = MaterialTheme.colorScheme.outline,
                        text = "Full Screen Dialog",
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
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.outline
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                onClick = {
                    isDialogOpen = true
                }
            ) {
                Text(text = "show full screen dialog")
            }
        }
    )
    { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
        ) {

        }
    }
}


@Preview(showBackground = false)
@Composable
fun ScreenDialogFullScreenPreview() {
    BaseTheme() {
        ScreenDialogFullScreen()
    }
}

data class InvoiceItem(
    val label: String,
    val value: String
)

data class InvoiceSection(
    val title: String,
    val items: List<InvoiceItem>
)

val invoiceSections = listOf(

    InvoiceSection(
        title = "Invoice Information",
        items = listOf(
            InvoiceItem("Invoice Number", "INV-2026-0001"),
            InvoiceItem("Invoice Date", "23/05/2026"),
            InvoiceItem("Due Date", "30/05/2026"),
            InvoiceItem("Status", "Paid")
        )
    ),

    InvoiceSection(
        title = "Customer Information",
        items = listOf(
            InvoiceItem("Customer Name", "John Doe"),
            InvoiceItem("Phone Number", "+66 98 123 4567"),
            InvoiceItem("Email", "john.doe@email.com"),
            InvoiceItem("Address", "Bangkok, Thailand")
        )
    ),

    InvoiceSection(
        title = "Payment Information",
        items = listOf(
            InvoiceItem("Payment Method", "Credit Card"),
            InvoiceItem("Transaction ID", "TXN93847291"),
            InvoiceItem("Currency", "USD"),
            InvoiceItem("Payment Status", "Successful")
        )
    ),

    InvoiceSection(
        title = "Order Summary",
        items = listOf(
            InvoiceItem("Product", "Wireless Headphones"),
            InvoiceItem("Quantity", "2"),
            InvoiceItem("Unit Price", "$59.99"),
            InvoiceItem("Subtotal", "$119.98")
        )
    ),

    InvoiceSection(
        title = "Charges",
        items = listOf(
            InvoiceItem("Shipping Fee", "$5.00"),
            InvoiceItem("Tax", "$8.50"),
            InvoiceItem("Discount", "-$10.00"),
            InvoiceItem("Total Amount", "$123.48")
        )
    )

)