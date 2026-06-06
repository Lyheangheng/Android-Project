package com.android.basic.android.component

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicSecureTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.KeyboardActionHandler
import androidx.compose.foundation.text.input.TextFieldDecorator
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.foundation.text.input.insert
import androidx.compose.foundation.text.input.maxLength
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.SecureTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.basic.android.R
import com.android.basic.android.ui.theme.BaseTheme
import kotlinx.coroutines.launch
import java.nio.file.WatchEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTextFields() {


    val nameTextFieldState = rememberTextFieldState(initialText = "Tuna Sandwich")
    val countryTextFieldState = rememberTextFieldState(initialText = "Thailand")
    val emailTextFieldState = rememberTextFieldState()
    val cardTextFieldState = rememberTextFieldState()
    val passwordTextFieldState = rememberTextFieldState()
    var expirationDateTextFieldState = rememberTextFieldState()
    var securityCodeTextFieldState = rememberTextFieldState()
    var visibilityIcon by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.outline
                ),
                title = {
                    Text(
                        text = "Text Fields"
                    )
                }, navigationIcon = {
                    IconButton(
                        onClick = {

                        }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_sort_24),
                            contentDescription = null,
                        )
                    }
                }, actions = {
                    BadgedBox(
                        badge = {
                            Badge(
                                containerColor = MaterialTheme.colorScheme.error
                            )
                        }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_notification_24),
                            contentDescription = null,
                        )
                    }
                })
        },
    ) { paddingValue ->

        Column(
            modifier = Modifier
                .padding(paddingValue)
                .fillMaxSize(),

            ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        text = "Payment Method"
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Full Name")
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    OutlinedTextField(
                        state = nameTextFieldState,
                        placeholder = { Text(text = "Tuna Sandwich") },
                        lineLimits = TextFieldLineLimits.SingleLine,
                        keyboardOptions = KeyboardOptions(
                            capitalization = KeyboardCapitalization.Characters,
                            imeAction = ImeAction.Next,
                            keyboardType = KeyboardType.Text,
                            showKeyboardOnFocus = true
                        ),
                        shape = RoundedCornerShape(10.dp)
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Country or Region")
                }

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedTextField(
                        state = countryTextFieldState,
                        placeholder = { Text(text = "Thailand") },
                        lineLimits = TextFieldLineLimits.SingleLine,
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next,
                            keyboardType = KeyboardType.Text,
                            showKeyboardOnFocus = true,
                        ),
                        shape = RoundedCornerShape(10.dp)
                    )
                }


                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Email")
                }

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedTextField(
                        state = emailTextFieldState,
                        lineLimits = TextFieldLineLimits.SingleLine,
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next,
                            keyboardType = KeyboardType.Email,
                            showKeyboardOnFocus = true
                        ),
                        suffix = {
                            Text(text = "@gmail.com")
                        },
                        shape = RoundedCornerShape(10.dp)
                    )
                }

                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Card Number")
                }

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedTextField(
                        state = cardTextFieldState,
                        lineLimits = TextFieldLineLimits.SingleLine,
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next,
                            keyboardType = KeyboardType.Number,
                            showKeyboardOnFocus = true
                        ),
                        placeholder = {
                            Text(text = "123 123 123 123")
                        },
                        shape = RoundedCornerShape(10.dp),
                        trailingIcon = {
                            Image(
                                painter = painterResource(R.drawable.lana_cover),
                                contentDescription = null,
                                modifier = Modifier.height(50.dp),
                                contentScale = ContentScale.Fit,
                            )
                        }
                    )
                }

                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Password")
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    SecureTextField(
                        modifier = Modifier
                            .border(color = MaterialTheme.colorScheme.inversePrimary, width = 1.dp, shape = RoundedCornerShape(10.dp)),
                        state = passwordTextFieldState,
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next,
                            keyboardType = KeyboardType.Password,
                            showKeyboardOnFocus = true
                        ),
                        shape = RoundedCornerShape(10.dp),
                        trailingIcon = {
                            IconButton(
                                onClick = {
                                    visibilityIcon = !visibilityIcon
                                }
                            ) {
                                if (visibilityIcon) Icon(painter = painterResource(R.drawable.ic_visibility_on_24), contentDescription = null)
                                else Icon(painter = painterResource(R.drawable.ic_visibility_off_24), contentDescription = null)

                            }
                        },
                        textObfuscationMode = if(visibilityIcon) TextObfuscationMode.Visible else TextObfuscationMode.Hidden,
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = MaterialTheme.colorScheme.background,
                        )

                    )
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                ){
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Row() {
                            Text(text = "Expiration Date")
                        }
                        Row() {
                            OutlinedTextField(
                                state = expirationDateTextFieldState,
                                lineLimits = TextFieldLineLimits.SingleLine,
                                keyboardOptions = KeyboardOptions(
                                    imeAction = ImeAction.Next,
                                    keyboardType = KeyboardType.Number,
                                    showKeyboardOnFocus = true
                                ),
                                inputTransformation = InputTransformation.maxLength(4),
                                outputTransformation = {
                                    if(length > 2){
                                        insert(2, "/")
                                    }
                                },
                                placeholder = {Text(text = "MM/YY")},
                                shape = RoundedCornerShape(10.dp),
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(15.dp))

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Row() {
                            Text(text = "Security Code")
                        }
                        Row() {
                            OutlinedTextField(
                                state = securityCodeTextFieldState,
                                lineLimits = TextFieldLineLimits.SingleLine,
                                keyboardOptions = KeyboardOptions(
                                    imeAction = ImeAction.Done,
                                    keyboardType = KeyboardType.Number,
                                    showKeyboardOnFocus = true
                                ),
                                inputTransformation = InputTransformation.maxLength(3),
                                placeholder = {Text(text = "CVC")},
                                shape = RoundedCornerShape(10.dp)
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
fun ScreenTextFieldsPreview() {
    BaseTheme {
        ScreenTextFields()
    }
}