package hospital;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalDiretor {
    private static final String FILE_PATH = "pacientes.txt";

    private static void salvarPacientes(List<Paciente> pacientes) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Paciente paciente : pacientes) {
                writer.write(paciente.toString());
                writer.newLine();
            }
        }
    }

    private static List<Paciente> carregarPacientes() throws IOException {
        List<Paciente> pacientes = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    pacientes.add(Paciente.fromString(linha));
                }
            }
        }
        return pacientes;
    }

    public static void adicionarPaciente(Paciente novoPaciente) throws IOException {
        List<Paciente> pacientes = carregarPacientes();
        pacientes.add(novoPaciente);
        salvarPacientes(pacientes);
    }

    public static void listarPacientes() throws IOException {
        List<Paciente> pacientes = carregarPacientes();
        for (Paciente paciente : pacientes) {
            paciente.listarPaciente();
        }
    }

    public static void alterarPaciente(int numero, double novoPeso, double novaAltura) throws IOException {
        List<Paciente> pacientes = carregarPacientes();
        for (Paciente paciente : pacientes) {
            if (paciente.getNumero() == numero) {
                paciente.setPeso(novoPeso);
                paciente.setAltura(novaAltura);
                break;
            }
        }
        salvarPacientes(pacientes);
    }

    public static void excluirPaciente(int numero) throws IOException {
        List<Paciente> pacientes = carregarPacientes();
        pacientes.removeIf(paciente -> paciente.getNumero() == numero);
        salvarPacientes(pacientes);
    }
}

