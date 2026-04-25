public class Ejercicio1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("========== EJERCICIO 1: Memory Leak ==========\n");

        // Tiempo de retraso de 15s
        Thread.sleep(15_000);

        RegistroMedico registro = new RegistroMedico();

        System.out.println("Creando 500 000 pacientes...");
        for (int i = 0; i < 500_000; i++) {
            Paciente p = new Paciente(String.valueOf(i), "Paciente_" + i, 20 + (i % 60));
            registro.agregarPaciente(p);
        }

        System.out.println("Pacientes en cache: " + RegistroMedico.tamañoCache());

        Paciente pNuevo = new Paciente("999999", "PacienteNuevo", 35);
        pNuevo = null;

        Thread.sleep(30_000);

        System.out.println("Fin del Ejercicio 1.");
    }
}
