package com.dicoding.asclepius

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result(
    val label: String,
    val score: Float
) : Parcelable
