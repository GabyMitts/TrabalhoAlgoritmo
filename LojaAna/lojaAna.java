// javac lojaAna.java --> Compilar o código e gerar as class
// java lojaAna.java --> Rodar o programa

import java.util.Scanner;

class Cliente {
  public String nome;
  private Produto[] carrinho;

  public void addCarrinho(Produto produto) {
    // Aumenta o array se necessário 
    if (this.carrinho == null) {
      this.carrinho = new Produto[1];
      this.carrinho[0] = produto;
    } else {
      Produto[] temp = this.carrinho; // Salva o array original em um temporario
      this.carrinho = new Produto[this.carrinho.length + 1]; // Aumenta o array em 1 posição
      
      for (int i = 0; i < temp.length; i++) { // Copia o array temporario no carrinho novamente
        this.carrinho[i] = temp[i];
      }

      this.carrinho[this.carrinho.length-1] = produto; // Adiciona o novo produto ao array
    }
    System.out.println("Produto "+produto.nome+" adicionado ao carrinho!");
  }

  public void delCarrinho(int index) {
    if (this.carrinho == null || this.carrinho.length < index) {
      System.out.println("Não existe produto a ser removido");
      return;
    } else {
      Produto[] temp = this.carrinho; // Salva o array original em um temporario
      this.carrinho = new Produto[this.carrinho.length - 1]; // Aumenta o array em 1 posição
      int cont2 = 0;
      for (int i = 0; i < temp.length; i++) { // Copia o array temporario no carrinho novamente
        if (i!= index-1) {
          this.carrinho[cont2] = temp[i];
          cont2++;
        }
      }
    }
  }

  public float calcCarrinho() {
    if (this.carrinho == null) {
      return 0;
    }
    float total = 0.0f;
    for (int i = 0; i < this.carrinho.length; i++) {
      total += this.carrinho[i].preco;
    }
    return total;
  }

  public void listarCarrinho() {
    if (this.carrinho == null) {
      System.out.println("Carrinho está vazio");
      return;
    }
    float total = 0.0f;
    for (int i = 0; i < this.carrinho.length; i++) {
      int item = i + 1;
      System.out.println("Item: "+ item +" ==> Produto: " + this.carrinho[i].nome + " ==> R$ " + this.carrinho[i].preco);
      total += this.carrinho[i].preco;
    }
    System.out.println("Total da compra: " + total);
  }

}

class Produto {
  public String nome;
  public float preco;
}

public class lojaAna {    
  public static void main(String[] args) { 
    Scanner ler = new Scanner(System.in); // Entrada padrão para java

    Cliente cliente = new Cliente();
    System.out.println("Nome do cliente:");
    cliente.nome = ler.nextLine();
    System.out.println("Bem vindo cliente " + cliente.nome);

    while (true) {
      System.out.println("Escolha uma opção: (A)dicionar produto | (R)emover produto | (L)istar compra  | (S)air ");
      String opcao = ler.nextLine();
      switch (opcao.toLowerCase()) {
          case "a":
            addProdutoCarrinho(cliente);
            break;
          case "l":
            cliente.listarCarrinho();
            break;
          case "s":
            System.exit(0);
          case "r":
            System.out.println("Item a excluir: ");
            String item = ler.nextLine();
            int index = Integer.parseInt(item);  // Converte String para inteiro
            cliente.delCarrinho(index);
          default:
            System.out.println("Opção inválida!");
            break;  // Sair do switch e continuar o loop
      }
    }
  }

  private static void addProdutoCarrinho(Cliente cliente) {
    Scanner ler = new Scanner(System.in); // Entrada padrão para java
    Produto produto = new Produto();
    System.out.print("Nome do produto:\n");
    produto.nome = ler.nextLine();
    System.out.print("Valor do produto:\n");
    String valor = ler.nextLine();
    produto.preco = Float.parseFloat(valor);
    cliente.addCarrinho(produto);  
    float total = cliente.calcCarrinho();
    System.out.println("Total da compra: " + total + "\n");
  }
}





