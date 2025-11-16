// Esta clase HIJA hereda de Aeronave.
public class Helicoptero extends Aeronave {

    // --- Atributos Propios ---
    // Solo los helicópteros tienen rotores.
    private final int numRotores;
    private final int altitudMaximaVuelo; // Límite de este helicóptero

    // --- Constructor ---
    public Helicoptero(String modelo, int anioFabricacion, String apodo, int numRotores) {
        // 1. OBLIGATORIO: Llamar al constructor del PADRE (Aeronave) primero.
        super(modelo, anioFabricacion, apodo);

        // 2. Inicializar atributos propios de esta clase.
        this.numRotores = numRotores;

        // Lógica de negocio simple: más rotores = más altitud (es un ejemplo)
        this.altitudMaximaVuelo = 2000 + (numRotores * 500);
    }

    // --- Implementación de Polimorfismo (@Override) ---
    // Esta es la implementación OBLIGATORIA del método abstracto.
    // Lógica de cómo un Helicóptero ajusta su altitud.
    @Override
    public void ajustarAltitud(int metrosCambio) {
        if (!super.isMotoresEncendidos()) {
            System.out.println(getModelo() + ": No se puede ajustar altitud, motores apagados.");
            return;
        }

        int altitudPotencial = super.altitudActual + metrosCambio;

        // Lógica de negocio (Restricciones)
        if (altitudPotencial > this.altitudMaximaVuelo) {
            // No podemos subir más allá del límite
            System.out.println(getModelo() + " alcanzó su altitud máxima de " + this.altitudMaximaVuelo + "m.");
            super.altitudActual = this.altitudMaximaVuelo;

        } else if (altitudPotencial < 0) {
            // No podemos bajar del suelo
            System.out.println(getModelo() + " ha aterrizado.");
            super.altitudActual = 0;

        } else {
            // Cambio normal
            super.altitudActual = altitudPotencial;
            if (metrosCambio > 0) {
                System.out.println(getModelo() + " ascendió a " + super.altitudActual + "m.");
            } else {
                System.out.println(getModelo() + " descendió a " + super.altitudActual + "m.");
            }
        }
    }

    // --- Métodos Propios ---
    // Este método SOLO existe en la clase Helicoptero.
    public void activarModoEstacionario() {
        if (super.isMotoresEncendidos() && super.altitudActual > 50) {
            System.out.println(getModelo() + " está en modo estacionario (flotando) a " + super.altitudActual + "m.");
        } else {
            System.out.println(getModelo() + ": Debe estar volando para activar el modo estacionario.");
        }
    }
}