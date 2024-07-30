package br.com.fiap.interest.utils

fun calculateInterests(capital: Double, tax: Double, period: Double): Double {
    return capital * tax / 100 * period
}

fun calculateAmount(capital: Double, interests: Double): Double {
    return capital + interests
}