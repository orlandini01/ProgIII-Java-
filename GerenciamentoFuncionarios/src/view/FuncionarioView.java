package view;

import controller.FuncionarioController;
import model.*;

import java.util.Scanner;

public class FuncionarioView {
    public static void main(String[] args) {
        FuncionarioController controller = new FuncionarioController();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Adicionar Funcionário");
            System.out.println("2. Listar Funcionários");
            System.out.println("3. Atualizar Funcionário");
            System.out.println("4. Remover Funcionário");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Salário: ");
                    double salario = scanner.nextDouble();
                    System.out.println("1. Desenvolvedor 2. Gerente 3. Treinador 4. Gerente Desenvolvedor");
                    int tipo = scanner.nextInt();
                    switch (tipo) {
                        case 1 -> controller.adicionarFuncionario(new Desenvolvedor(nome, salario));
                        case 2 -> controller.adicionarFuncionario(new Gerente(nome, salario));
                        case 3 -> controller.adicionarFuncionario(new Treinador(nome, salario));
                        case 4 -> controller.adicionarFuncionario(new GerenteDesenvolvedor(nome, salario));
                    }
                    break;
                case 2:
                    controller.listarFuncionarios();
                    break;
                case 3:
                    System.out.print("Nome do funcionário para atualizar: ");
                    String nomeAtualizar = scanner.nextLine();
                    System.out.print("Novo salário: ");
                    double novoSalario = scanner.nextDouble();
                    controller.atualizarFuncionario(nomeAtualizar, novoSalario);
                    break;
                case 4:
                    System.out.print("Nome do funcionário para remover: ");
                    String nomeRemover = scanner.nextLine();
                    controller.removerFuncionario(nomeRemover);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
