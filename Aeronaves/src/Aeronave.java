// Esta es la clase PADRE, similar a tu clase Vehiculo.
// 'abstract' significa que no podemos crear un objeto "Aeronave" genérico.
// Solo sirve como plantilla para clases más específicas (hijas).
public abstract class Aeronave {

    // --- Encapsulamiento (Atributos) ---

    // Private: Solo accesibles DENTRO de esta clase. Requieren Getters/Setters.
    private final String modelo;
    private final int anioFabricacion;
    private String apodo; // Un apodo o matrícula que sí podemos cambiar.

    // Protected: Accesible por esta clase y por CUALQUIER CLASE HIJA (Helicoptero, Avion).
    protected int altitudActual; // En metros
    protected boolean motoresEncendidos;

    // --- Constructor ---
    // Garantiza que cada Aeronave que se cree DEBA tener estos datos.
    public Aeronave(String modelo, int anioFabricacion, String apodo) {
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.apodo = apodo;

        // Estado inicial por defecto
        this.altitudActual = 0;
        this.motoresEncendidos = false;
        System.out.println("Se ha registrado la aeronave: " + modelo);
    }

    // --- Métodos Comunes (Heredados por todos) ---

    public void encenderMotores() {
        if (!this.motoresEncendidos) {
            this.motoresEncendidos = true;
            System.out.println(this.modelo + " (" + this.apodo + ") ha encendido motores.");
        } else {
            System.out.println(this.modelo + " ya tiene los motores encendidos.");
        }
    }

    public void apagarMotores() {
        if (this.motoresEncendidos && this.altitudActual == 0) {
            this.motoresEncendidos = false;
            System.out.println(this.modelo + " (" + this.apodo + ") ha apagado motores en tierra.");
        } else if (this.altitudActual > 0) {
            System.out.println("¡PELIGRO! No se pueden apagar motores en vuelo.");
        } else {
            System.out.println("Los motores ya estaban apagados.");
        }
    }

    // --- Método Abstracto (Polimorfismo) ---
    // Obligamos a las clases hijas (Helicoptero, Avion) a definir CÓMO
    // ajustan su altitud. Este es el equivalente a tu método acelerar().
    // Recibe un cambio (positivo para subir, negativo para bajar).
    public abstract void ajustarAltitud(int metrosCambio);


    // --- Getters y Setters (Acceso controlado) ---

    // Getters para leer atributos 'final' (solo lectura)
    public String getModelo() {
        return modelo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    // Getter y Setter para un atributo modificable
    public String getApodo() {
        return apodo;
    }

    public void setApodo(String nuevoApodo) {
        if (nuevoApodo != null && !nuevoApodo.trim().isEmpty()) {
            this.apodo = nuevoApodo;
            System.out.println("Matrícula/Apodo actualizado a: " + nuevoApodo);
        } else {
            System.out.println("ERROR: El apodo no es válido.");
        }
    }

    // Getters de estado
    public int getAltitudActual() {
        return altitudActual;
    }

    public boolean isMotoresEncendidos() {
        return motoresEncendidos;
    }
}