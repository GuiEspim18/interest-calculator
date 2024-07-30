package br.com.fiap.interest.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import br.com.fiap.interest.components.Field
import br.com.fiap.interest.components.Results

@Composable
fun InterestsScreen(
    interestsScreenViewModel: InterestsScreenViewModel
) {

    val capital by interestsScreenViewModel.capital.observeAsState(initial = "")
    val tax by interestsScreenViewModel.tax.observeAsState(initial = "")
    val period by interestsScreenViewModel.period.observeAsState(initial = "")
    val interests by interestsScreenViewModel.interests.observeAsState(initial = 0.0)
    val amount by interestsScreenViewModel.amount.observeAsState(initial = 0.0)

    Column (
        modifier = Modifier
            .background(Color(0xFFF0F0F0))
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Cálculo de Juros Simples",
            color = Color(0xFFB82B2B),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFA5D8DF)
            )
        ) {
            Column(
                modifier = Modifier.
                padding(20.dp)
            ) {
                Text(
                    text = "Dados do investimento",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF555555)
                )
                Field(
                    label = "Valor do investimento",
                    placeHolder = "Quanto deseja investir?",
                    value = capital,
                    keyboardType = KeyboardType.Number,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    updateValue = {
                        interestsScreenViewModel.onCapitalChanged(it)
                    }
                )
                Spacer(modifier = Modifier.height(5.dp))
                Field(
                    label = "Taxa de juros mensal",
                    placeHolder = "Quanto deseja investir?",
                    value = tax,
                    keyboardType = KeyboardType.Number,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    updateValue = {
                        interestsScreenViewModel.onTaxChange(it)
                    }
                )
                Spacer(modifier = Modifier.height(5.dp))
                Field(
                    label = "Perído em meses",
                    placeHolder = "Quanto deseja investir?",
                    value = period,
                    keyboardType = KeyboardType.Number,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    updateValue = {
                        interestsScreenViewModel.onPeriodChange(it)
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = {
                        interestsScreenViewModel.calculateInterests()
                        interestsScreenViewModel.calculateAmount()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(text = "Calcular")
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Results(
            interests = interests,
            amount = amount
        )
    }
}