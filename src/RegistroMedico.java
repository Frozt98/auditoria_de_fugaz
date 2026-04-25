import java.util.ArrayList;
import java.util.List;

public class RegistroMedico {

    private static List<Object> cache = new ArrayList<>();

    public void agregarPaciente(Paciente p) {
        cache.add(p);
    }

    public static int tamañoCache() {
        return cache.size();
    }
}
