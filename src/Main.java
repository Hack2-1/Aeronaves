//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//
//public class Main {
//    public static void main(String[] args) {
//        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.println("Hello and welcome!");
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }
//    }
//
//}

// Main.java

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // CREACIÓN DE OBJETOS: Instanciando las clases hijas

        // Coche usa el constructor de Coche
        Coche miCoche = new Coche("Tesla Model 3", 2024, "Rojo", 4);

        // Motocicleta usa el constructor de Motocicleta
        Motocicleta miMoto = new Motocicleta("Yamaha YZF-R6", 2023, "Azul", 600);

        System.out.println("Prueba de Clases Individuales");

        // Prueba de Encapsulamiento y Métodos propios
        System.out.println("Información del coche: " + miCoche.getModelo() + " " + miCoche.getAnio() + " " + miCoche.getColor()); // Uso del Getter (Encapsulamiento)
        System.out.println("Modelo de la moto: " + miMoto.getModelo() + " " + miMoto.getAnio() + " " + miMoto.getColor()); // Uso del Getter (Encapsulamiento)
        miCoche.setColor("Negro Mate"); // Uso del Setter
        miMoto.setColor("Verde"); // Uso del Setter
        miCoche.prendeClima(); //Método único dal Coche
        miMoto.hacerCaballito(); // Método único de Motocicleta

        System.out.println("------------------------------------");

        // POLIMORFISMO: Crear una lista de tipo Padre (Vehiculo)
        // La lista puede contener cualquier clase que herede de Vehiculo.
        List<Vehiculo> listaVehiculos = new ArrayList<>();
        listaVehiculos.add(miCoche); // Un Coche es un Vehiculo
        listaVehiculos.add(miMoto);  // Una Motocicleta es un Vehiculo

        System.out.println("Demostración de Polimorfismo");

        // ITERACIÓN: Ejecutando el mismo método en diferentes objetos
        for (Vehiculo vehiculo : listaVehiculos) {

            // Java llama automáticamente al método 'encender()' definido en Vehiculo (Herencia)
            vehiculo.encender();


            // Java llama automáticamente al método 'acelerar()' específico de cada objeto:
            // Si es Coche o Moto, usa la lógica de aceleración de Coche.
            vehiculo.acelerar(20);

            System.out.println("------------------------------------");
        }

        // PRUEBA ADICIONAL: Ejecución de la lógica de negocio
        miMoto.acelerar(50); // Muestra la aceleración de la moto (con el factor de cilindrada)
        miCoche.acelerar(50); // Muestra la aceleración del coche (con su propia lógica)

    }
}
