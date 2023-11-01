public class Programador {
    private String nombre;
    private String apellidos;
    private String contrasena;

    public Programador(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void validarContrasena(String contrasena, String confirmacion) throws Exception {
        if (!contrasena.equals(confirmacion)) {
            throw new Exception("Las contraseñas no coinciden.");
        }

        if (!contrasenaValida(contrasena)) {
            throw new Exception("La contraseña no cumple con los requisitos.");
        }

        setContrasena(contrasena);
    }

    public boolean validarContrasena(String contrasena) {
        return contrasenaValida(contrasena);
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
        for (char c : contrasena.toCharArray()) {
            if (Character.isUpperCase(c)) {
                tieneMayuscula = true;
            } else if (Character.isDigit(c)) {
                tieneNumero = true;
            } else if (isCaracterEspecial(c)) {
                tieneCaracterEspecial = true;
            }
        }

        return tieneMayuscula && tieneNumero && tieneCaracterEspecial;
    }

    private boolean isCaracterEspecial(char c) {
        String caracteresEspeciales = "@#$%^&+=!*.";
        return caracteresEspeciales.indexOf(c) != -1;
    }
}
