// Esta es OTRA clase HIJA que hereda de Aeronave.
public class AvionComercial extends Aeronave {

    // --- Atributos Propios ---
    private final int capacidadPasajeros;
    private final int altitudCrucero; // Altitud óptima de vuelo
    private boolean trenAterrizajeDesplegado;

    // --- Constructor ---
    public AvionComercial(String modelo, int anioFabricacion, String apodo, int capacidadPasajeros) {
        // 1. Llamar al constructor del PADRE (Aeronave)
        super(modelo, anioFabricacion, apodo);

        // 2. Inicializar atributos propios
        this.capacidadPasajeros = capacidadPasajeros;
        this.trenAterrizajeDesplegado = true; // Empieza en tierra

        // Lógica de negocio: aviones más grandes vuelan más alto
        this.altitudCrucero = (capacidadPasajeros > 200) ? 11000 : 9000; // 11km o 9km
    }

    // --- Implementación de Polimorfismo (@Override) ---
    // Lógica de cómo un Avión ajusta su altitud (diferente al helicóptero)
    @Override
    public void ajustarAltitud(int metrosCambio) {
        if (!super.isMotoresEncendidos()) {
            System.out.println(getModelo() + ": No se puede ajustar altitud, motores apagados.");
            return;
        }

        // --- Lógica de negocio PROPIA del Avión ---
        // Restricción 1: No puede subir si el tren está desplegado
        if (metrosCambio > 0 && this.trenAterrizajeDesplegado) {
            System.out.println(getModelo() + ": ¡Debe retraer el tren de aterrizaje antes de subir!");
            return; // No hace nada
        }

        // Restricción 2: Debe desplegar el tren si baja mucho
        if (metrosCambio < 0 && (super.altitudActual + metrosCambio) < 1000) {
            System.out.println(getModelo() + ": Altitud baja, desplegando tren de aterrizaje...");
            this.desplegarTrenAterrizaje(); // Llama a su propio método
        }
        // --- Fin de la lógica propia ---

        int altitudPotencial = super.altitudActual + metrosCambio;

        // Restricciones de altitud (similares al helicóptero pero con su límite)
        if (altitudPotencial > this.altitudCrucero) {
            System.out.println(getModelo() + " alcanzó su altitud crucero de " + this.altitudCrucero + "m.");
            super.altitudActual = this.altitudCrucero;

        } else if (altitudPotencial <= 0) {
            System.out.println(getModelo() + " ha aterrizado.");
            super.altitudActual = 0;

        } else {
            super.altitudActual = altitudPotencial;
            System.out.println(getModelo() + " ahora vuela a " + super.altitudActual + "m.");
        }
    }

    // --- Métodos Propios ---
    // Estos métodos SOLO existen en AvionComercial.

    public void retraerTrenAterrizaje() {
        if (this.trenAterrizajeDesplegado && super.altitudActual > 100) {
            this.trenAterrizajeDesplegado = false;
            System.out.println(getModelo() + ": Tren de aterrizaje retraído.");
        } else {
            System.out.println(getModelo() + ": No se puede retraer el tren (aún en tierra o ya retraído).");
        }
    }

    public void desplegarTrenAterrizaje() {
        if (!this.trenAterrizajeDesplegado) {
            this.trenAterrizajeDesplegado = true;
            System.out.println(getModelo() + ": Tren de aterrizaje desplegado para aterrizar.");
        }
    }
}