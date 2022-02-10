package com.dio.simuladordepartidas.domain

import com.google.gson.annotations.SerializedName

data class Match (
        @SerializedName("descricao")
        val description:String,
        @SerializedName("local")
        val local:Place,
        @SerializedName("mandante")
        val homeTime: Team,
        @SerializedName("visitante")
        val awayTeam: Team,
)