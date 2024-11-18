package hospital;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Adicionar Paciente");
            System.out.println("2. Listar Pacientes");
            System.out.println("3. Alterar Paciente");
            System.out.println("4. Excluir Paciente");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            try {
                switch (opcao) {
                    case 1 -> {
                        System.out.print("Número: ");
                        int numero = scanner.nextInt();
                        System.out.print("Peso: ");
                        double peso = scanner.nextDouble();
                        System.out.print("Altura: ");
                        double altura = scanner.nextDouble();
                        HospitalDiretor.adicionarPaciente(new Paciente(numero, peso, altura));
                    }
                    case 2 -> HospitalDiretor.listarPacientes();
                    case 3 -> {
                        System.out.print("Número do paciente a alterar: ");
                        int numero = scanner.nextInt();
                        System.out.print("Novo Peso: ");
                        double novoPeso = scanner.nextDouble();
                        System.out.print("Nova Altura: ");
                        double novaAltura = scanner.nextDouble();
                        HospitalDiretor.alterarPaciente(numero, novoPeso, novaAltura);
                    }
                    case 4 -> {
                        System.out.print("Número do paciente a excluir: ");
                        int numero = scanner.nextInt();
                        HospitalDiretor.excluirPaciente(numero);
                    }
                    case 5 -> {
                        System.out.println("Saindo...");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Opção inválida!");
                }
            } catch (IOException e) {
                System.err.println("Erro ao acessar o arquivo: " + e.getMessage());
            }
        }
    }
}

