public class Coche extends Vehiculo {

    // Atributo propio del coche, solo los coches tienen este atributo.
    private int numPuertas;

    // CONSTRUCTOR (Llamada al Padre, inicializamos el objeto)
    // Un Coche necesita todos los datos de un Véhiculo más su propio dato (numPuertas).
    public Coche(String modelo, int anio, String color, int numPuertas) {

        // El constructor de la clase hija DEBE llamar primero al constructor del Padre.
        // La palabra clave 'super()' invoca el constructor de Véhiculo.
        super(modelo, anio, color);

        // Inicialización de atributos propios del Coche
        this.numPuertas = numPuertas;
    }

    // POLIMORFISMO (Implementación obligatoria)
    // Sobrescritura (@Override): Implementamos el método abstracto de Vehiculo.
    // Esta es la lógica única de cómo acelera un Coche.
    @Override
    public void acelerar(int incremento) {

        // Accedemos a la variable 'velocidadActual' porque es 'protected' en Véhiculo.
        this.velocidadActual += incremento;


        System.out.println("El Coche " + getModelo() + ", año " + getAnio() + ", color " + getColor() +
                " acelero y ahora va a " + this.velocidadActual + " km/h.");
    }

    // Métodos propios del coche

    // Getter para el atributo propio del Coche
    public int getNumPuertas() {
        return numPuertas;
    }

    public void abrirPuerta() {
        System.out.println("Puerta abierta. Este coche tiene " + this.numPuertas + " puertas.");
    }

    public void prendeClima(){
        System.out.println("El auto " + getModelo() + " prendió el clima");
    }
}
