package com.android.can2022

import java.io.Serializable

data class EquipeDetails(
    val groupe: String,
    val coach: String,
    val star: String,
    val playersCalledUp: List<String>
) : Serializable

