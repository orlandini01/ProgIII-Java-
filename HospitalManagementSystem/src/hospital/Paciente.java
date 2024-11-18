package hospital;

public class Paciente {
    private int numero;
    private double peso;
    private double altura;

    public Paciente(int numero, double peso, double altura) {
        this.numero = numero;
        this.peso = peso;
        this.altura = altura;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void listarPaciente() {
        System.out.println("Número: " + numero);
        System.out.println("Peso: " + peso);
        System.out.println("Altura: " + altura);
        System.out.println("-------------------------");
    }

    @Override
    public String toString() {
        return numero + ";" + peso + ";" + altura;
    }

    public static Paciente fromString(String linha) {
        String[] partes = linha.split(";");
        int numero = Integer.parseInt(partes[0]);
        double peso = Double.parseDouble(partes[1]);
        double altura = Double.parseDouble(partes[2]);
        return new Paciente(numero, peso, altura);
    }
}

