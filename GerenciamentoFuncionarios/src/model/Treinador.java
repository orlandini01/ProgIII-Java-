package model;

public class Treinador extends Funcionario implements Treina {
    public Treinador(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Treinador: " + getNome() + ", Salário: " + getSalario());
    }

    @Override
    public void ensinarTecnologia() {
        System.out.println(getNome() + " está ensinando novas tecnologias...");
    }

    @Override
    public void motivarEquipe() {
        System.out.println(getNome() + " está motivando a equipe...");
    }
}
