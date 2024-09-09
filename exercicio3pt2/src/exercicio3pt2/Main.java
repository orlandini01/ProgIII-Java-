package exercicio3pt2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Produto produto = new Produto();

		System.out.print("Digite o nome do produto: ");
		produto.setNome(scanner.nextLine());

		System.out.print("Digite a quantidade do produto: ");
		produto.setQuantidade(scanner.nextInt());

		System.out.print("Digite o preço unitário: ");
		produto.setPrecoUnitario(scanner.nextDouble());

		double valorTotal = produto.getQuantidade() * produto.getPrecoUnitario();

		System.out.println("Produto: " + produto.getNome());
		System.out.println("Valor total: R$ " + valorTotal);

		scanner.close();
	}

}
