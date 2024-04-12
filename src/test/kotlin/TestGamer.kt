import br.com.jmfragallo.alugames.modelo.Gamer

fun main() {
    val gamer1 = Gamer("João", "joao@emial.com")
    println(gamer1)

    val gamer2 = Gamer("Marcos", "marcos@email.com", "25/12/1999", "mark")

    println(gamer2)

    gamer1.let {
        it.dataNascimento = "25/12/1999"
        it.usuario = "jonn"
    }
    println(gamer1)

}