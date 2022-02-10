package com.dio.simuladordepartidas.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Match (
        @SerializedName("descricao")
        val description:String,
        @SerializedName("local")
        val local:Place,
        @SerializedName("mandante")
        val homeTime: Team,
        @SerializedName("visitante")
        val awayTeam: Team,
): Parcelable