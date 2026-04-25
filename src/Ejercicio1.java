public class Ejercicio1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("========== EJERCICIO 1: Memory Leak con lista estática ==========\n");

        RegistroMedico registro = new RegistroMedico();

        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memoria usada ANTES del bucle: " + (memoriaAntes / 1024) + " KB");

        System.out.println("Creando 500,000 pacientes en el cache estático...");
        for (int i = 0; i < 500_000; i++) {
            Paciente p = new Paciente(String.valueOf(i), "Paciente_" + i, 20 + (i % 60));
            registro.agregarPaciente(p);
        }

        long memoriaDespues = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memoria usada DESPUÉS del bucle: " + (memoriaDespues / 1024) + " KB");
        System.out.println(
                "Memoria consumida por los 500,000 pacientes: " + ((memoriaDespues - memoriaAntes) / 1024) + " KB");
        System.out.println("Pacientes en cache: " + RegistroMedico.tamañoCache());

        Paciente pNuevo = new Paciente("999999", "PacienteNuevo", 35);
        System.out.println("\npNuevo creado: " + pNuevo);
        pNuevo = null;
        System.out.println("pNuevo = null → Elegible para el Garbage Collector");

        runtime.gc();
        long memoriaPostGC = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memoria después de gc(): " + (memoriaPostGC / 1024) + " KB");

        // Pausa para que VisualVM pueda perfilar la memoria
        System.out.println("\nEsperando 30 segundos para análisis en VisualVM...");
        System.out.println("Abre VisualVM, conecta a 'Ejercicio1' y ve a la pestaña 'Monitor'.");
        Thread.sleep(30_000);

        System.out.println("Fin del Ejercicio 1.");
    }
}
