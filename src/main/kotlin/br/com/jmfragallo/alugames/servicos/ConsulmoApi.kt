package br.com.jmfragallo.alugames.servicos

import com.google.gson.Gson
import org.example.br.com.jmfragallo.alugames.modelo.InfoJogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsulmoApi {

    fun buscaJogo(id: String): InfoJogo {
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()

        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()

        val gson = Gson()

        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

        return meuInfoJogo
    }
}