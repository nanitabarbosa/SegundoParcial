# SegundoParcial
inicializamos creando un una clase padre llamada vehiculo, compartiendo las caracteristicas propias.
de alli se inicializa el contructor donde inicializamos en this los atributos de la clase padre, para llamarlos como parametro, los cuales son placa, tipo y propietario.

Se inicializa la clase espacioparqueadero con los atributos numero de espacio, el tipo permitido y su estado el cual se va utilizar un boolean para saber si esta ocupado o desocupado.

Empezamos con los metodos los cuales se van a llamar luego en el main que son asignarvehiculo el cual va a permitir cambiar el estado del esacio a ocupado y el otro metodo el cual sera liberar espacio, este permite cambiar el estado del espacio disponible.



Empezamos creando las arrayslist que van a tener una extension de espacio parqueadero el cual se va a llamar espacio y otra llamada vehiculos con extension vehiculo.

Declaranos tres funciones void ya que no van a retornar ningun valor, el cual uno es de los espacios y se van a llamar parametros como numero y tipo permitido para que la funcion, funcione correctamente.
la otra se va a llamar registrar vehiculo el cual va a llamar por parametro la placa el tipo y el propietario.

luego creamos una clase gestionparqueadero que va a permitir registrar todos los vehiculos que entren que se supone con un scanner, y con los metodos anteriores permitir ver que espacio esta disponibles y a su vez asignar el espacio disponible, y asi verificar que un carro no ocupe el espacio de una moto y asi sucesivamente.

inicializamos el main e importamos arraylist y list para recorrer todo los metodos qe pusimos arriba










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
    private String tipoPermitido; // "carro" o "moto"
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

    public boolean isOcupado() {
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
