package com.android.basic.android.feature.checkBox

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.basic.android.R
import com.android.basic.android.ui.theme.BaseTheme


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun ScreenCheckBox(
    onBack: () -> Unit = {}
) {

    val checkBoxes = remember {
        mutableStateListOf(
            CheckBoxItem(4, "Item 4"),
            CheckBoxItem(1, "Item 1"),
            CheckBoxItem(2, "Item 2"),
            CheckBoxItem(3, "Item 3"),
        )
    }

    val count by remember {
        derivedStateOf {
            checkBoxes.count { it.isChecked }
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
                            painter = painterResource(R.drawable.baseline_arrow_back_ios_new_24),
                            contentDescription = null
                        )
                    }
                },
                title = {
                    Text(
                        text = "CheckBox, $count",
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
                    TextButton(
                        onClick = {
                            checkBoxes.replaceAll { it.copy(isChecked = true) }
                            checkBoxes.forEach { println(it.isChecked) }
                        }
                    ) {
                        Text(
                            text = "Select all"
                        )
                    }
                },
            )
        }
    )
    { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(color = Color.LightGray.copy(alpha = 0.3f))
        ) {
            items(checkBoxes.size) { index ->
                val item = checkBoxes[index]


                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = item.isChecked,
                        onCheckedChange = { isChecked ->
                            checkBoxes[index] = item.copy(isChecked = isChecked)
                        }
                    )
                    Text(
                        text = if (item.isChecked) "Checked: ${item.title}" else item.title
                    )
                    Spacer(modifier = Modifier.width(35.dp))
                    Text(
                        modifier = Modifier
                            .clickable(
                                onClick = {
                                    checkBoxes.removeAt(index)
                                }
                            )
                            .border(width = 1.dp, color = Color.Black)
                            .background(color = Color.Red),
                        text = "delete",
                    )
                }
                HorizontalDivider()
            }
        }
    }
}


@Preview(showBackground = false)
@Composable
fun ScreenCheckBoxPreview() {
    BaseTheme() {
        ScreenCheckBox()
    }
}


data class CheckBoxItem(
    val id: Int,
    val title: String,
    val isChecked: Boolean = false
)

