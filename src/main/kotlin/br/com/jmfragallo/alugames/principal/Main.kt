package org.example.br.com.jmfragallo.alugames.principal

import br.com.jmfragallo.alugames.servicos.ConsulmoApi
import org.example.br.com.jmfragallo.alugames.modelo.Jogo
import java.util.*


fun main() {

    val leitura = Scanner(System.`in`)
    println("Digite o códigp do jogo que deseja")
    val busca = leitura.nextLine()

    val buscaApi = ConsulmoApi()
    val informacaoJogo = buscaApi.buscaJogo(busca)

    var novoJogo: Jogo? = null

    val resultado = runCatching {
        novoJogo = Jogo(
            informacaoJogo.info.title,
            informacaoJogo.info.thumb
        )

        println(novoJogo)
    }

    resultado.onFailure {
        println("Jogo não encontrado. Tente outro id")
    }
    resultado.onSuccess {
        println("Deseja inserir uma descrição personalizada? S/N")
        val opcao = leitura.nextLine()
        if (opcao.equals("s", true)) {
            println("Insira sua descrição personalizada")
            val descricaoPersonalizada = leitura.nextLine()
            novoJogo?.descricao = descricaoPersonalizada
        } else {
            novoJogo?.descricao = novoJogo?.titulo
        }

        println(novoJogo)
    }

}