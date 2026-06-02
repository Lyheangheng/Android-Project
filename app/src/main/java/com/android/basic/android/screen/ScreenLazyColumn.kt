package com.android.basic.android.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.basic.android.R

@Composable
fun ScreenLazyColumn() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = Color.Gray
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
           items(accountList) { account ->
                  Row(
                      modifier = Modifier
                          .fillMaxWidth()
                          .height(80.dp)
                          .padding(5.dp)
                          .background(
                              color = MaterialTheme.colorScheme.background,
                              shape = RoundedCornerShape(20.dp)),
                      verticalAlignment = Alignment.CenterVertically
                  ) {
                      Image(
                          painter = painterResource(id = account.profileImage),
                          modifier = Modifier
                              .padding(start = 16.dp)
                              .size(45.dp)
                              .clip(CircleShape),
                          contentDescription = null
                      )
                      Column(
                          modifier = Modifier
                              .padding(start = 16.dp)
                      ) {
                          Text(
                              fontWeight = FontWeight.Bold,
                              text = account.accountName
                          )
                          Text(
                              fontSize = 12.sp,
                              text = account.accountNo
                          )
                      }
                      Spacer(modifier = Modifier.weight(1f))
                          Row(
                              modifier = Modifier
                                  .padding(end = 10.dp)
                                  .fillMaxWidth(),
                              horizontalArrangement = Arrangement.End

                          ) {
                              Text(
                                  fontWeight = FontWeight.Bold,
                                  text = account.availableBalance.toString())
                              Spacer(modifier = Modifier.size(5.dp))
                              Text(text = account.currencyCode.code)
                          }
                  }
               }
            item {
                for (account in accountList) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .padding(5.dp)
                            .background(
                                color = Color.Cyan.copy(alpha = 0.5f),
                                shape = RoundedCornerShape(20.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = account.profileImage),
                            modifier = Modifier
                                .padding(start = 16.dp)
                                .size(45.dp)
                                .clip(CircleShape),
                            contentDescription = null
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 16.dp)
                        ) {
                            Text(
                                fontWeight = FontWeight.Bold,
                                text = account.accountName
                            )
                            Text(
                                fontSize = 12.sp,
                                text = account.accountNo
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Row(
                            modifier = Modifier
                                .padding(end = 10.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.End

                        ) {
                            Text(
                                fontWeight = FontWeight.Bold,
                                text = account.availableBalance.toString()
                            )
                            Spacer(modifier = Modifier.size(5.dp))
                            Text(text = account.currencyCode.code)
                        }
                    }
                }
            }
            itemsIndexed(accountList) { index, account ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .padding(5.dp)
                        .background(
                            color = MaterialTheme.colorScheme.background,
                            shape = RoundedCornerShape(20.dp)
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = account.profileImage),
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .size(45.dp)
                            .clip(CircleShape),
                        contentDescription = null
                    )
                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp)
                    ) {
                        Text(
                            fontWeight = FontWeight.Bold,
                            text = account.accountName
                        )
                        Text(
                            fontSize = 12.sp,
                            text = account.accountNo
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Row(
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.End

                    ) {
                        Text(
                            fontWeight = FontWeight.Bold,
                            text = account.availableBalance.toString()
                        )
                        Spacer(modifier = Modifier.size(5.dp))
                        Text(text = account.currencyCode.code)
                    }
                }
            }
        }
            }
        }


@Preview(showBackground = false)
@Composable
fun PreviewScreenLazyColumn(){
    ScreenLazyColumn()
}


data class AccountModel(
    val accountNo: String,
    val accountType: AccountType,
    val availableBalance: Double,
    val currencyCode: CurrencyCode,
    val accountName: String,
    val isPrimary: Boolean,
    var profileImage: Int,
)

enum class AccountType(val code: String){
    LOAN_ACCOUNT("10000"),
    SAVINGS_ACCOUNT("20000"),
    DEPOSIT_ACCOUNT("30000"),
    GOLD_SAVING("40000")
}

enum class CurrencyCode(val code: String) {
    KHD("KHD"),
    USD("USD"),

    BAHT("BAHT")
}
val accountList = listOf(
    AccountModel("1000000001", AccountType.SAVINGS_ACCOUNT, 1200.50, CurrencyCode.USD, "Tun", true, R.drawable.profile_1),
    AccountModel("1000000002", AccountType.SAVINGS_ACCOUNT, 850.75, CurrencyCode.USD, "Tuna", false, R.drawable.profile_2),
    AccountModel("1000000003", AccountType.DEPOSIT_ACCOUNT, 5000.00, CurrencyCode.USD, "Tuna_Sandwich", false, R.drawable.profile_3),
    AccountModel("1000000004", AccountType.LOAN_ACCOUNT, 15000.00, CurrencyCode.USD, "DoubleMint", false, R.drawable.profile_4),
    AccountModel("1000000005", AccountType.GOLD_SAVING, 2000000.5, CurrencyCode.KHD, "Sandwich", false, R.drawable.profile_5),

    AccountModel("1000000006", AccountType.SAVINGS_ACCOUNT, 3000000.00, CurrencyCode.KHD, "Pisey Heng", false, R.drawable.profile_6),
    AccountModel("1000000007", AccountType.SAVINGS_ACCOUNT, 780.40, CurrencyCode.USD, "Rithy Chea", false, R.drawable.profile_7),
    AccountModel("1000000008", AccountType.DEPOSIT_ACCOUNT, 10000.00, CurrencyCode.USD, "Bopha Noun", false, R.drawable.profile_8),
    AccountModel("1000000009", AccountType.LOAN_ACCOUNT, 5000.00, CurrencyCode.USD, "Kosal Phan", false, R.drawable.profile_9),
    AccountModel("1000000010", AccountType.GOLD_SAVING, 100000000.2, CurrencyCode.KHD, "Malis Touch", false, R.drawable.profile_10),

    AccountModel("1000000011", AccountType.SAVINGS_ACCOUNT, 640.20, CurrencyCode.USD, "Sokun Meas", false, R.drawable.profile_11),
    AccountModel("1000000012", AccountType.SAVINGS_ACCOUNT, 9200000.10, CurrencyCode.KHD, "Chenda Vong", false, R.drawable.profile_12),
    AccountModel("1000000013", AccountType.DEPOSIT_ACCOUNT, 20000.00, CurrencyCode.USD, "Dalin Srey", false, R.drawable.profile_13),
    AccountModel("1000000014", AccountType.LOAN_ACCOUNT, 25000.00, CurrencyCode.USD, "Vichea Keo", false, R.drawable.profile_14),
    AccountModel("1000000015", AccountType.SAVINGS_ACCOUNT, 1500000.00, CurrencyCode.KHD, "Rina Yim", false, R.drawable.profile_15)
)

























