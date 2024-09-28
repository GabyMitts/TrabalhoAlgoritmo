// javac MeuPrograma.java --> Compilar o código e gerar as class
// java MeuPrograma.java --> Rodar o programa

import java.util.Scanner;

class Cliente {
  public String nome;
  private Float saldo = 1000f;
  
  public void depositar(float valor) {
    this.saldo = this.saldo + valor;
  }

  public void sacar(float valor) {
    if (this.saldo > valor) {
      this.saldo = this.saldo - valor;
    } else {
      System.out.println("Saldo insuficiente!");
    }
  }

  public Float consultarSaldo() {
    return this.saldo;
  }

}

public class MeuPrograma {    
  public static void main(String[] args) { // Obrigatorio para iniciar um programa em java
    Scanner ler = new Scanner(System.in); // Entrada padrão para java

    Cliente cliente1 = new Cliente(); //
    System.out.println("Digite o nome do Cliente:");
    cliente1.nome = ler.nextLine();

    System.out.println("Quanto deseja depositar:");
    float valorDeposito = ler.nextFloat();
    cliente1.depositar(valorDeposito);

    System.out.println("Quanto deseja sacar:");
    float valorSaque = ler.nextFloat();
    cliente1.sacar(valorSaque);

    System.out.println("Cliente: "+ cliente1.nome);
    float saldoCliente = cliente1.consultarSaldo();
    System.out.println("Saldo: "+ saldoCliente);

    ler.close();

  } 
}