package org.example.br.com.jmfragallo.alugames.modelo

import com.google.gson.annotations.SerializedName

data class Jogo ( val titulo:String, val capa:String ) {
    var descricao:String? = null
    override fun toString(): String {
        return  "\nJogo: $titulo \n" +
                "Capa: $capa \n" +
                "Descrição: $descricao"
    }


}