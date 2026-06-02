package com.android.basic.android.screen




import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.basic.android.R


@Composable
fun CardView() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(10.dp)
                .clip(RoundedCornerShape(15.dp))
        ) {
            Image(
                painter = painterResource(id = cardTemplate.cardBackGround),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .matchParentSize()
            )
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .background(color = Color.Transparent, shape = RoundedCornerShape(20.dp)),
            ) {
                // Symbol and VISA
                Row(
                    modifier = Modifier
                        .padding(15.dp),
//                .background(color = Color.Gray)
                ) {
//                    Text(
//                        modifier = Modifier
//                            .padding(start = 20.dp),
//                        text = "SYMBOL",
//                        color = Color.White,
//                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        fontWeight = FontWeight.Bold,
                        fontSize = 23.sp,
                        color = Color.White,
                        text = cardTemplate.cardType.cardName
                    )
                }
                // cardNumber
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp, bottom = 15.dp),
//                .background(color = Color.Gray),
                ) {
                    Text(
                        modifier = Modifier
                            .padding(start = 20.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        text = cardTemplate.cardNumber,
                        color = Color.White,
                    )
                }
                //CardHolderName and Expiry Date
                Row(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 20.dp),
                        fontSize = 12.sp,
                        text = "Card Holder name"
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        fontSize = 12.sp,
                        modifier = Modifier
                            .padding(end = 20.dp),
                        text = "Expiry Date",
                        color = Color.White,
                    )
                }
                // actual name and date
                Row(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp, bottom = 20.dp)
                ) {
                    Text(
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier
                            .padding(start = 20.dp),
                        text = cardTemplate.cardHolderName,
                        color = Color.White,
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        modifier = Modifier
                            .padding(end = 40.dp),
                        fontWeight = FontWeight.Bold,
                        text = cardTemplate.expiryDate,
                        color = Color.White,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun PreviewCardView() {
    CardView()
}

data class CardModel(
    val cardType: CardType,
    val cardNumber: String,
    val cardHolderName: String,
    val expiryDate: String,
    val cardBackGround: Int
)

enum class CardType(val cardName: String){
    VISA("VISA"),
    MASTERCARD("MASTERCARD"),
    AMEX("AMEX")
}


val cardTemplate = CardModel(CardType.VISA, "4111 1111 1111 0007", "Frank Miller", "06/25", R.drawable.background_card)

//val cardList = listOf(
//    CardModel(CardType.VISA, "4111 1111 1111 0001", "John Doe", "12/27"),
//    CardModel(CardType.MASTERCARD, "5500 0000 0000 0002", "Alice Smith", "11/26"),
//    CardModel(CardType.AMEX, "3400 0000 0000 003", "Bob Johnson", "10/25"),
//
//    CardModel(CardType.VISA, "4111 1111 1111 0004", "Charlie Brown", "09/28"),
//    CardModel(CardType.MASTERCARD, "5500 0000 0000 0005", "David Lee", "08/27"),
//    CardModel(CardType.AMEX, "3400 0000 0000 006", "Emma Wilson", "07/26"),
//
//    CardModel(CardType.VISA, "4111 1111 1111 0007", "Frank Miller", "06/25"),
//    CardModel(CardType.MASTERCARD, "5500 0000 0000 0008", "Grace Kim", "05/29"),
//    CardModel(CardType.AMEX, "3400 0000 0000 009", "Henry Clark", "04/28"),
//
//    CardModel(CardType.VISA, "4111 1111 1111 0010", "Isabella Davis", "03/27"),
//    CardModel(CardType.MASTERCARD, "5500 0000 0000 0011", "Jack White", "02/26"),
//    CardModel(CardType.AMEX, "3400 0000 0000 012", "Karen Young", "01/25"),
//
//    CardModel(CardType.VISA, "4111 1111 1111 0013", "Liam Scott", "12/29"),
//    CardModel(CardType.MASTERCARD, "5500 0000 0000 0014", "Mia Hall", "11/28"),
//    CardModel(CardType.AMEX, "3400 0000 0000 015", "Noah King", "10/27")
//)
