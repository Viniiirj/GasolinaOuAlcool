package com.viniramos.gasolinaoualcool

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Calculadora(
    val calcularMelhorPreco: Unit,
    val precoAlcool: Double,
    val precoGasolina: Double,
    val resultado: String
) : Parcelable
