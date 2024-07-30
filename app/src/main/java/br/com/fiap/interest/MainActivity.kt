package br.com.fiap.interest

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.interest.components.Field
import br.com.fiap.interest.ui.theme.InterestTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InterestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {

                }
            }
        }
    }
}

@Composable
fun Greeting() {

    var capital by remember {
        mutableStateOf("")
    }

    var tax by remember {
        mutableStateOf("")
    }

    var period by remember {
        mutableStateOf("")
    }

    var interests by remember {
        mutableStateOf(0.0)
    }

    var amount by remember {
        mutableStateOf(0.0)
    }

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
                        capital = it
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
                        tax = it
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
                        period = it
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(text = "Calcular")
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
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
                        text = "0.00",
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
                        text = "0.00",
                        modifier = Modifier
                            .padding(start = 10.dp),
                        color = Color(0xFFF0F0F0),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    InterestTheme {
        Greeting()
    }
}