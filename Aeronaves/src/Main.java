import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- Creación de Objetos ---");

        // Creamos instancias de las clases HIJAS.
        // No podemos hacer 'new Aeronave()' porque es abstracta.
        Helicoptero miHeli = new Helicoptero("Apache AH-64", 2020, "Halcón Uno", 2);
        AvionComercial miAvion = new AvionComercial("Boeing 747", 2022, "Reina de los Cielos", 400);

        System.out.println("\n--- Prueba de Métodos Propios ---");
        // Llamamos a métodos que solo existen en sus clases específicas
        miHeli.activarModoEstacionario(); // Falla (está en tierra)
        miAvion.retraerTrenAterrizaje();  // Falla (está en tierra)

        System.out.println("\n------------------------------------");
        System.out.println("--- DEMOSTRACIÓN DE POLIMORFISMO ---");
        System.out.println("------------------------------------\n");

        // Creamos una lista del tipo PADRE (Aeronave)
        List<Aeronave> miHangar = new ArrayList<>();

        // Guardamos objetos de clases HIJAS (Polimorfismo)
        miHangar.add(miHeli);   // Un Helicoptero ES UNA Aeronave
        miHangar.add(miAvion);  // Un AvionComercial ES UNA Aeronave

        // Iteramos sobre la lista de tipo PADRE
        for (Aeronave nave : miHangar) {
            System.out.println("\n** Probando: " + nave.getModelo() + " **");

            // 1. Llamamos a un método común (heredado)
            nave.encenderMotores();

            // 2. Llamamos al método abstracto (Polimorfismo)
            // Java sabe a cuál 'ajustarAltitud' llamar:
            // - Si 'nave' es un Helicoptero, usa la lógica del helicóptero.
            // - Si 'nave' es un Avion, usa la lógica del avión (que revisa el tren de aterrizaje).
            nave.ajustarAltitud(500); // El Avión fallará aquí a propósito

            // 3. Prueba de métodos específicos (requiere ajuste)
            if (nave instanceof AvionComercial) {
                // Si sabemos que es un avión, podemos "forzarlo" a usar sus métodos
                AvionComercial avion = (AvionComercial) nave;
                avion.retraerTrenAterrizaje(); // Aún falla (no ha subido)
            }

            // 4. Segundo intento de subir
            System.out.println("* Segundo intento de ajuste de altitud *");
            nave.ajustarAltitud(1500);

            // 5. Apagado
            nave.apagarMotores(); // El Avión fallará (está en el aire)
            System.out.println("-------------------------");
        }

        System.out.println("\n--- Prueba Final (Aterrizaje) ---");
        // Demostración de la lógica de aterrizaje
        System.out.println("Altitud actual del avión: " + miAvion.getAltitudActual() + "m");
        miAvion.ajustarAltitud(+3000); // Esto debe desplegar el tren
        System.out.println("Altitud final del avión: " + miAvion.getAltitudActual() + "m");
        miAvion.apagarMotores(); // Ahora sí puede apagar
    }
}