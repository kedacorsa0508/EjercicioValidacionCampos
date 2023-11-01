import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestProgramador {

    @Test
    public void testContrasenaValida() {
        Programador programador = new Programador("Nombre", "Apellidos");

        assertTrue(programador.validarContrasena("Am27Kd08*"));
        assertTrue(programador.validarContrasena("password")); // No contiene mayúsculas
    }

    

    @Test
    public void testValidarContrasena() {
        Programador programador = new Programador("Nombre", "Apellidos");

        try {
            programador.validarContrasena("Am27Kd08*", "Am27Kd08*"); // Contraseña válida
        } catch (Exception e) {
            fail("No se esperaba excepción: " + e.getMessage());
        }

        try {
            programador.validarContrasena("Am27Kd08*", "WrongPassword"); // Contraseña inválida
            fail("Se esperaba una excepción");
        } catch (Exception e) {
            assertEquals("Las contraseñas no coinciden.", e.getMessage());
        }
    }

}
