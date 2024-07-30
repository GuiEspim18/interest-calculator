package br.com.fiap.interest.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Results(
    interests: Double,
    amount: Double,
//    modifier: Modifier
) {
    Card (
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF4CAF50),
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp),
    ) {
        Column (
            modifier = Modifier
                .padding(13.dp)
        ) {
            Text(
                text = "Resultado",
                color = Color(0xFFF0F0F0),
                fontWeight = FontWeight.Bold
            )
            Row {
                Text(
                    text = "Juros",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "$interests",
                    modifier = Modifier
                        .padding(start = 10.dp),
                    color = Color(0xFFF0F0F0),
                    fontWeight = FontWeight.Bold
                )
            }
            Row {
                Text(
                    text = "Montante",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "$amount",
                    modifier = Modifier
                        .padding(start = 10.dp),
                    color = Color(0xFFF0F0F0),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}