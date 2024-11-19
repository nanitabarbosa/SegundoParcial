import java.util.ArrayList;
import java.util.List;

// Clase Vehiculo
class Vehiculo {
    private String placa;
    // El tipo de vehiculo: "carro" o "moto"
    private String tipo; 
    private String propietario;

    public Vehiculo(String placa, String tipo, String propietario) {
        this.placa = placa;
        this.tipo = tipo.toLowerCase();
        this.propietario = propietario;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPropietario() {
        return propietario;
    }
}

// Clase EspacioParqueadero
class EspacioParqueadero {
    private int numeroEspacio;
    // "carro" o "moto"
    private String tipoPermitido; 
    //false = "disponible" o true = "ocupado"
    private boolean ocupado;

    public EspacioParqueadero(int numeroEspacio, String tipoPermitido) {
        this.numeroEspacio = numeroEspacio;
        this.tipoPermitido = tipoPermitido.toLowerCase();
        this.ocupado = false;
    }

    public int getNumeroEspacio() {
        return numeroEspacio;
    }

    public String getTipoPermitido() {
        return tipoPermitido;
    }

    public boolean getOcupado() {
        return ocupado;
    }

    public boolean asignarVehiculo(Vehiculo vehiculo) {
        if (!ocupado && vehiculo.getTipo().equals(tipoPermitido)) {
            ocupado = true;
            return true;
        }
        return false;
    }

    public void liberarEspacio() {
        ocupado = false;
    }
}

// Clase GestionParqueadero
class GestionParqueadero {
    private List<EspacioParqueadero> espacios;
    private List<Vehiculo> vehiculos;

    public GestionParqueadero() {
        this.espacios = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
    }



    public void registrarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        System.out.println("Vehículo registrado: " + vehiculo.getPlaca());
    }

    public void mostrarEspaciosDisponibles() {
        System.out.println("Espacios disponibles:");
        for (EspacioParqueadero espacio : espacios) {
            if (!espacio.getOcupado()) {
                System.out.println("Espacio " + espacio.getNumeroEspacio() + " (Para: " + espacio.getTipoPermitido() + ")");
            }
        }
    }

    public void asignarEspacio(String placa) {
        Vehiculo vehiculo = buscarVehiculoPorPlaca(placa);
        if (vehiculo == null) {
            System.out.println("Vehículo no encontrado.");
            return;
        }

        for (EspacioParqueadero espacio : espacios) {
            if (!espacio.getOcupado() && espacio.getTipoPermitido().equals(vehiculo.getTipo())) {
                if (espacio.asignarVehiculo(vehiculo)) {
                    System.out.println("Espacio " + espacio.getNumeroEspacio() + " asignado al vehículo con placa " + placa);
                    return;
                }
            }
        }
        System.out.println("No hay espacios disponibles para el vehículo con placa " + placa);
    }

    public void liberarEspacio(int numeroEspacio) {
        for (EspacioParqueadero espacio : espacios) {
            if (espacio.getNumeroEspacio() == numeroEspacio) {
                if (espacio.getOcupado()) {
                    espacio.liberarEspacio();
                    System.out.println("Espacio " + numeroEspacio + " liberado.");
                    return;
                } else {
                    System.out.println("El espacio " + numeroEspacio + " ya está disponible.");
                    return;
                }
            }
        }
        System.out.println("Espacio no encontrado.");
    }

    public void agregarEspacio(int numeroEspacio, String tipoPermitido) {
        espacios.add(new EspacioParqueadero(numeroEspacio, tipoPermitido));
        System.out.println("Espacio " + numeroEspacio + " agregado (Para: " + tipoPermitido + ").");
    }

    private Vehiculo buscarVehiculoPorPlaca(String placa) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                return vehiculo;
            }
        }
        return null;
    }
}

// Clase principal para probar el sistema
public class SistemaParqueadero {
    public static void main(String[] args) {
        GestionParqueadero gestion = new GestionParqueadero();

        // Agregar espacios
        gestion.agregarEspacio(1, "carro");
        gestion.agregarEspacio(2, "moto");
        gestion.agregarEspacio(3, "carro");

        // Registrar vehículos
        gestion.registrarVehiculo(new Vehiculo("ABC123", "carro", "Juan Perez"));
        gestion.registrarVehiculo(new Vehiculo("XYZ789", "moto", "Ana Gomez"));

        // Mostrar espacios disponibles
        gestion.mostrarEspaciosDisponibles();

        // Asignar espacios
        gestion.asignarEspacio("ABC123");
        gestion.asignarEspacio("XYZ789");

        // Mostrar espacios disponibles después de asignar
        gestion.mostrarEspaciosDisponibles();

        // Liberar un espacio
        gestion.liberarEspacio(1);

        // Mostrar espacios disponibles después de liberar
        gestion.mostrarEspaciosDisponibles();
    }
}
