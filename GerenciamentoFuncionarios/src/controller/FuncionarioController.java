package controller;

import model.*;

import java.io.*;
import java.util.ArrayList;

public class FuncionarioController {
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private final String ARQUIVO = "funcionarios.txt";

    public FuncionarioController() {
        carregarDados();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        salvarDados();
    }

    public void listarFuncionarios() {
        for (Funcionario f : funcionarios) {
            f.mostrarDetalhes();
        }
    }

    public Funcionario buscarFuncionarioPorNome(String nome) {
        for (Funcionario f : funcionarios) {
            if (f.getNome().equalsIgnoreCase(nome)) {
                return f;
            }
        }
        return null;
    }

    public void atualizarFuncionario(String nome, double novoSalario) {
        Funcionario funcionario = buscarFuncionarioPorNome(nome);
        if (funcionario != null) {
            funcionario.setSalario(novoSalario);
            salvarDados();
        }
    }

    public void removerFuncionario(String nome) {
        Funcionario funcionario = buscarFuncionarioPorNome(nome);
        if (funcionario != null) {
            funcionarios.remove(funcionario);
            salvarDados();
        }
    }

    private void salvarDados() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Funcionario f : funcionarios) {
                writer.write(f.getClass().getSimpleName() + ";" + f.getNome() + ";" + f.getSalario());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void carregarDados() {
        File file = new File(ARQUIVO);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    String[] partes = linha.split(";");
                    String tipo = partes[0];
                    String nome = partes[1];
                    double salario = Double.parseDouble(partes[2]);

                    switch (tipo) {
                        case "Desenvolvedor":
                            funcionarios.add(new Desenvolvedor(nome, salario));
                            break;
                        case "Gerente":
                            funcionarios.add(new Gerente(nome, salario));
                            break;
                        case "Treinador":
                            funcionarios.add(new Treinador(nome, salario));
                            break;
                        case "GerenteDesenvolvedor":
                            funcionarios.add(new GerenteDesenvolvedor(nome, salario));
                            break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
