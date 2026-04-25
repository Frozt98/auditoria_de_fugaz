public class Ejercicio2 {
    public static void main(String[] args) {
        System.out.println("========== EJERCICIO 2: Trazabilidad de Punteros ==========\n");

        Paciente original = new Paciente("101", "Inicial", 25);
        System.out.println("Antes de procesar → original: " + original);

        Trazador trazador = new Trazador();
        trazador.procesar(original);

        System.out.println("Después de procesar → original: " + original);
        System.out.println("\nNombre final de 'original': \"" + original.getNombre() + "\"");
    }
}
