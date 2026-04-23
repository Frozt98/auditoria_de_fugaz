import java.util.ArrayList;
import java.util.List;

public class RegistroMedico {
    private
    static List<Object> cache = new ArrayList<>();
     public void agregarPaciente(Paciente p) {
         if (p != null) {
             cache.add(p);
         }else{
             System.out.println("Paciente no encontrado");
         }
     }
     }

