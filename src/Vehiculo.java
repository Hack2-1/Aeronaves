public abstract class Vehiculo {
    //abstract se utiliza para decir que no se puede crear objetos directamente de esta clase, solo sirve para heredar

    // ----------Encapsulamiento---------------//

    // Atributos privados
    // Private: Solo accesibles DENTRO de esta clase. Necesitan Getters/Setters.
    private String modelo;
    private int anio;
    private String color;
    // Protected: Accesible por esta clase y por CUALQUIER CLASE HIJA (Coche, Motocicleta).
    protected int velocidadActual = 0;

    // Constructor (inicialización de estados)
    // Se usa para garantizar que los atributos se inicialicen al crear el objeto.
    public Vehiculo (String modelo, int anio, String color){
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
    }

    // Métodos
    public void encender(){
        System.out.println(this.modelo + this.anio + this.color + "encendido");
    }

    public void apagar(){
        this.velocidadActual = 0;
        System.out.println(this.modelo + this.anio + this.color + "apagado");
    }

    // Polimorfismo: Obligatorio para las clases hijas.
    // Cada subclase (Coche, Motocicleta) definirá su propia lógica de aceleración.
    public abstract void acelerar(int incremento);


    // GETTERS Y SETTERS (acceso Controlado)

    // Getters: Permiten LEER los atributos privados.
    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public String getColor() {
        return color;
    }

    public int getVelocidadActual() {
        return velocidadActual;
    }

    // Setter: Permite MODIFICAR un atributo privado (con lógica de validación).
    public void setColor(String nuevoColor) {
        // Validación de ejemplo (Encapsulamiento en acción)
        if (nuevoColor != null && !nuevoColor.trim().isEmpty()) {
            this.color = nuevoColor;
            System.out.println("Color de " + this.modelo + " cambiado a " + nuevoColor);
        } else {
            System.out.println("ERROR: El color no es válido.");
        }
    }
}

