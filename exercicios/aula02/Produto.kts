class Produto(
    val nome: String,
    var preco: Double,
    var estoque: Int
) {
    fun vender( quantidade: Int){

        if(estoque <= 0){
            println("Sem estoque")
        }
        
        else{
            estoque -= quantidade
            println("Item vendido")
        }
    }

    fun repor(quantidade: Int){
        estoque += quantidade
        println("\nQuantidade adicionada ao estoque")
    }

    fun exibirInfo(){
        println("=======================================================================")
        println("nome: $nome preco: $preco estoque: $estoque")
    }
  }

    var produto1 = Produto("Camiseta", 29.99, 10)
    var produto2 = Produto("Calca", 59.99, 15)
    var produto3 = Produto("Tenis", 99.99, 18)
    var produto4 = Produto("Meia", 9.99, 15)
    var produto5 = Produto("Bone", 19.99, 8)

    produto1.vender(2)
    produto2.vender(3)
    produto3.vender(4)

    produto1.exibirInfo()
    produto2.exibirInfo()
    produto3.exibirInfo()

    produto1.repor(5)
    produto2.repor(3)
    produto3.repor(2)

    produto1.exibirInfo()
    produto2.exibirInfo()
    produto3.exibirInfo()