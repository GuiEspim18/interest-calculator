package br.com.fiap.interest.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun Field(
    label: String,
    placeHolder: String,
    value: String,
    keyboardType: KeyboardType,
    modifier: Modifier,
    updateValue: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        modifier = modifier,
        onValueChange = updateValue,
        label = {
            Text(text = label)
        },
        placeholder = {
            Text(text = placeHolder)
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
}