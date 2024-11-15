import java.util.Scanner;

public class Jugador { //Clase padre
    protected String equipo; //protected para la segurdad de los atributos padre
    protected int edad;
    protected String nombre;

    public Jugador(String equipo, String nombre, int edad) { //Constructor padre
        this.equipo = equipo;
        this.edad = edad;
        this.nombre = nombre;
    }

    // metodo padre
    public void mostrarInfoPadre() {
        System.out.println("Nombre del equipo: " + equipo);
        System.out.println("Nombre del jugador: " + nombre);
        System.out.println("Edad: " + edad);
    }

    static class Portero extends Jugador { //Subclase Portero
        private int atajadas; //Tiene sus atributos propios
        private int golesRecibidos;

        //Aca solo le cambie el nombre (no confundirse) a los argumentos para que no salgan todos con el mismo nombre y edad
        public Portero(String equipo, String nombrePortero, int edadPortero, int atajadas, int golesRecibidos) { //Su constructor que usa los atributos heredados del padre
            super(equipo, nombrePortero, edadPortero); //Estos son los heredados
            //Cuando queramos heredar metodos especificos(NO TODOS) podemos usar la siguiente linea
            //super.NombreMetodoEspecifico();
            //En este caso no uso este porque el metodo que necesitamos del padre es uno solo y sera el mismo para todos
            this.atajadas = atajadas; //Ademas uso el this. para asignar los valores a los atributos propios
            this.golesRecibidos = golesRecibidos;
        }

        public int Atajadas(int atajadas) { //Metodos propios de la subclase Portero
            return atajadas;
        }

        public int GolesRecibidos(int golesRecibidos) { //Lo mismo de arriba
            return golesRecibidos;
        }

        @Override //Sobreescribir
        public void mostrarInfoPadre() { //Sobreescribimos al metodo del padre
            super.mostrarInfoPadre(); //Hacemos referencia al metodo del padre
            System.out.println("Atajadas: " + Atajadas(atajadas)); //Y le agregamos los metodos propios de
            System.out.println("Goles recibidos: " + GolesRecibidos(golesRecibidos) + "\n"); //la subclase Portero
        }
    }

    static class Defensa extends Jugador {//Subclase Defensa
        private int bloqueos; //atributos propios

        //Aqui tambien le cambie los nombres para diferenciar
        public Defensa(String equipo, String nombreDefensa, int edadDefensa, int bloqueos) {
            super(equipo, nombreDefensa, edadDefensa); //Lo mismo que hice arriba
            this.bloqueos = bloqueos;
        }

        public int Bloqueos(int bloqueos) {//Metodos propios de la subclase Defensa
            return bloqueos;
        }

        @Override //Y sobreescribimos para agregar el metodo propio
        public void mostrarInfoPadre() {
            super.mostrarInfoPadre();
            System.out.println("Bloqueos: " + Bloqueos(bloqueos) + "\n"); //Lo agregamos
        }
    }

    //Tambien cambie los nombres
    static class Delantero extends Jugador {//Subclase Delantero
        public Delantero(String equipo, String nombreDelantero, int edadDelantero){ //Aqui no cambio nada
            super(equipo, nombreDelantero, edadDelantero); //Porque el problema no lo requeria
            //Por eso simplemente uso el constructor heredado por el padre
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del equipo: "); //Entrada por teclado de cada posicion
        String equipo = scanner.nextLine();
        System.out.println("Ingrese el nombre del Portero: ");
        String nombrePortero = scanner.nextLine();
        System.out.println("Ingrese la edad del Portero: ");
        int edadPortero = scanner.nextInt();
        System.out.println("Ingrese las atajadas realizadas por el portero: ");
        int atajadas = scanner.nextInt();
        System.out.println("Ingrese los goles recibidos por el portero: ");
        int golesRecibidos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\n");
        System.out.println("Ingrese el nombre del Defensa: "); //Con  sus respectivas variables
        String nombreDefensa = scanner.nextLine();
        System.out.println("Ingrese la edad del Defensa: "); //edad'DEFENSA'
        int edadDefensa = scanner.nextInt();
        System.out.println("Ingrese el numero de bloqueos realizados por el defensa: ");
        int bloqueos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\n");
        System.out.println("Ingrese el nombre del Delantero: ");//Igual aca
        String nombreDelantero = scanner.nextLine();
        System.out.println("Ingrese la edad del Delantero: ");
        int edadDelantero = scanner.nextInt();
        scanner.nextLine();

        //Instanciamos cada subclase e imprimimos la informacion
        Portero portero = new Portero(equipo, nombrePortero, edadPortero, atajadas,golesRecibidos);
        System.out.println("\nInformacion del Portero"); //Para que se vea mas ordenado
        portero.mostrarInfoPadre();
        Defensa defensa = new Defensa(equipo, nombreDefensa, edadDefensa, bloqueos);
        System.out.println("\nInformacion del Defensa");
        defensa.mostrarInfoPadre();
        Delantero delantero = new Delantero(equipo, nombreDelantero, edadDelantero);
        System.out.println("Informacion del Delantero");
        delantero.mostrarInfoPadre();
    }
}

