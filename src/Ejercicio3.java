public class Ejercicio3 {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("========== EJERCICIO 3: Clonación Profunda (Deep Copy) ==========\n");

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
            System.out.println("\nCopia PROFUNDA lograda. El cambio en P2 NO afectó a P1.");
        } else {
            System.out.println("\nSolo copia SUPERFICIAL. El cambio en P2 TAMBIÉN afectó a P1.");
        }
    }
}
