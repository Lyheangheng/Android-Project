package com.android.basic.android.feature.datePicker


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.android.basic.android.R
import com.android.basic.android.ui.theme.BaseTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


enum class DateTimeFormatPattern(val format: String){
    mm_dd_yyyy("MM/dd/yyyy"),
    dd_mm_yyyy("dd/MM/yyyy"),
    yyyy_mm_dd("yyyy/MM/dd"),
    dd_mm("dd/MM"),
    mm_dd("MM/dd"),
    yyyy_mm("yyyy/MM"),
    dd_month_yyyy("dd MMMM yyyy"),
    dd_mmm_yyyy_hh_mm("dd MMM yyyy HH:mm")
}


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun ScreenDatePicker(onBack: () -> Unit = {}) {

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
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_back_ios_new_24),
                            contentDescription = null
                        )
                    }
                },
                title = {
                    Text(
                        text = "Date Picker",
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
        },
        bottomBar = {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                onClick = {showDatePicker = true}
            ) {
                Text(
                    text = "show datePicker"
                )
            }
        }
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


@Preview(showBackground = false)
@Composable
fun ScreenDatePickerPreview() {
    BaseTheme() {
        ScreenDatePicker()
    }
}

fun convertMillisToDate(millis: Long, pattern: String): String {
    val formatter = SimpleDateFormat(pattern, Locale.getDefault())
    return formatter.format(Date(millis))
}
