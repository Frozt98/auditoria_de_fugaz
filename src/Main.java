public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║     PRÁCTICA 002 - AUDITORÍA DE FUGAS (MEMORY LEAKS)        ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");

        // ======================== EJERCICIO 1 ========================
        System.out.println("\n========== EJERCICIO 1: Memory Leak con lista estática ==========\n");

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
        System.out.println("Memoria consumida por los 500,000 pacientes: " + ((memoriaDespues - memoriaAntes) / 1024) + " KB");
        System.out.println("Pacientes en cache: " + RegistroMedico.tamañoCache());

        Paciente pNuevo = new Paciente("999999", "PacienteNuevo", 35);
        System.out.println("\npNuevo creado: " + pNuevo);
        pNuevo = null;
        System.out.println("pNuevo = null → Ahora es elegible para el Garbage Collector");

        runtime.gc();
        long memoriaPostGC = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memoria después de System.gc(): " + (memoriaPostGC / 1024) + " KB");
        System.out.println("\n→ pNuevo SÍ fue recolectado (ya no tiene referencia).");
        System.out.println("→ Los 500,000 pacientes en 'cache' NO fueron recolectados");
        System.out.println("  porque la lista estática mantiene referencias activas. MEMORY LEAK.");

        // ======================== EJERCICIO 2 ========================
        System.out.println("\n========== EJERCICIO 2: Trazabilidad de Punteros ==========\n");

        Paciente original = new Paciente("101", "Inicial", 25);
        System.out.println("Antes de procesar → original: " + original);

        Trazador trazador = new Trazador();
        trazador.procesar(original);

        System.out.println("Después de procesar → original: " + original);
        System.out.println("\nNombre final de 'original': \"" + original.getNombre() + "\"");

        // ======================== EJERCICIO 3 ========================
        System.out.println("\n========== EJERCICIO 3: Clonación Profunda (Deep Copy) ==========\n");

        Diagnostico diagnosticoOriginal = new Diagnostico("Gripe estacional");
        Paciente P1 = new Paciente("201", "Carlos", 40, diagnosticoOriginal);
        System.out.println("P1 original: " + P1);

        Paciente P2 = (Paciente) P1.clone();
        System.out.println("P2 clonado:  " + P2);

        P2.getDiagnostico().setDescripcion("Neumonía severa");
        System.out.println("\n--- Después de modificar el Diagnóstico de P2 ---");
        System.out.println("P1 diagnóstico: " + P1.getDiagnostico().getDescripcion());
        System.out.println("P2 diagnóstico: " + P2.getDiagnostico().getDescripcion());

        if (!P1.getDiagnostico().getDescripcion().equals(P2.getDiagnostico().getDescripcion())) {
            System.out.println("\n✅ Copia PROFUNDA lograda. El cambio en P2 NO afectó a P1.");
        } else {
            System.out.println("\n❌ Solo copia SUPERFICIAL. El cambio en P2 TAMBIÉN afectó a P1.");
        }
    }
}