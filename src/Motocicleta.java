public class Motocicleta extends Vehiculo {

    // Atributo propio de la moto, solo las motos tienen este atributo.
    private int cilindradaCC;

    // CONSTRUCTOR (Llamada al Padre, inicializamos el objeto)
    // Un Coche necesita todos los datos de un Vehiculo MÁS su propio dato (cilindrada).
    public Motocicleta(String modelo, int anio, String color, int cilindradaCC) {

        // El constructor de la clase hija DEBE llamar primero al constructor del Padre.
        // La palabra clave 'super()' invoca el constructor de Vehiculo.
        super(modelo, anio, color);

        // Inicialización de atributos propios del Coche
        this.cilindradaCC = cilindradaCC;
    }

    // POLIMORFISMO (Implementación obligatoria)
    // Sobrescritura (@Override): Implementamos el método abstracto de Vehiculo.
    // Esta es la lógica única de cómo acelera un Coche.
    @Override
    public void acelerar(int incremento) {

        // Accedemos a la variable 'velocidadActual' porque es 'protected' en Vehiculo.
        this.velocidadActual += incremento;


        System.out.println("La Moto " + getModelo() + ", año " + getAnio() + ", color " + getColor() +
                " acelero y ahora va a " + this.velocidadActual + " km/h.");
    }

    // Métodos propios de la Motocicleta

    // Getter para el atributo propio del Coche
    public void hacerCaballito() {
        System.out.println("La moto " + getModelo() + " esta haciendo un caballito");
    }


}
