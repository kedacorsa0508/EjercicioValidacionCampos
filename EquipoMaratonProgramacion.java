import java.util.Scanner;

public class EquipoMaratonProgramacion {
    // ... (resto del código)

    public EquipoMaratonProgramacion(String nombreEquipo, String universidad, String lenguajeProgramacion) {
    }

    public void establecerContrasena(Programador programador, String contrasena) throws Exception {
        if (contrasenaValida(contrasena)) {
            programador.validarContrasena(contrasena, contrasena); // Confirmación de la contraseña
        } else {
            throw new Exception("La contraseña no cumple con los requisitos.");
        }
    }

    private boolean contrasenaValida(String contrasena) {
        // Mínimo 8 caracteres
        if (contrasena.length() < 8) {
            return false;
        }

        // No debe tener espacios en blanco
        if (contrasena.contains(" ")) {
            return false;
        }

        // Debe tener al menos un carácter en mayúscula, un número y un carácter especial
        boolean tieneMayuscula = false;
        boolean tieneNumero = false;
        boolean tieneCaracterEspecial = false;
        String caracteresEspeciales = "@#$%^&+=!";

        for (char c : contrasena.toCharArray()) {
            if (Character.isUpperCase(c)) {
                tieneMayuscula = true;
            } else if (Character.isDigit(c)) {
                tieneNumero = true;
            } else if (caracteresEspeciales.indexOf(c) != -1) {
                tieneCaracterEspecial = true;
            }
        }

        return tieneMayuscula && tieneNumero && tieneCaracterEspecial;
    }

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Nombre del equipo = ");
            String nombreEquipo = teclado.next();
            System.out.println("Universidad = ");
            String universidad = teclado.next();
            System.out.println("Lenguaje de programación = ");
            String lenguajeProgramacion = teclado.next();
            EquipoMaratonProgramacion equipo = new EquipoMaratonProgramacion(nombreEquipo, universidad, lenguajeProgramacion);

            System.out.println("Simulación de creación de usuario y contraseña:");

            try {
                Programador programador = new Programador("Nombre", "Apellidos");
                System.out.println("Usuario creado: " + programador.getNombre() + " " + programador.getApellidos());

                System.out.println("Ingrese una contraseña:");
                String contrasena = teclado.next();
                System.out.println("Confirme la contraseña:");
                String confirmacion = teclado.next();

                try {
                    equipo.establecerContrasena(programador, contrasena);
                    System.out.println("Contraseña establecida con éxito.");
                } catch (Exception e) {
                    System.out.println("Error al establecer la contraseña: " + e.getMessage());
                }
            } catch (Exception e) {
                System.out.println("Error al agregar el programador: " + e.getMessage());
            }
        }
    }
}
