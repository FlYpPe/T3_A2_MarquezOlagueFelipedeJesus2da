import java.util.Stack;
import java.util.Scanner;

interface RentaPeliculas {

	public void cargarBaseDatos();

	public void rentar();

	public void devolverPelicula();

	public void mostrarDisponibles();

	public boolean pilaLlena();

	public boolean pilaVacia();
}

class ImplementacionPilaDinamica implements RentaPeliculas {

	Stack<Pelicula> mS = new Stack<>();

	private int cima = 4;
	private int tamañoPila = 5;
	Pelicula peliculas[] = new Pelicula[5];

	public void cargarBD() {
		mS.push(new Pelicula("1) juracic park", "Dinosaurios"));
		mS.push(new Pelicula("2) terminator", "accion"));
		mS.push(new Pelicula("3) eso", "Miedo"));
		mS.push(new Pelicula("4) viernes 13", "Terror"));
		mS.push(new Pelicula("5) avengers", "Accion"));

		System.out.println("La base de datos esta activa");
	}

	public void rentaPeliculas() {
		if (pilaVacia()) {
			System.out.println("No hay mas peliculas para rentar");
		} else {
			peliculas[cima] = mS.peek();
			System.out.println("Has rentado la pelicula " + peliculas[cima].getTitulo() + " del genero "
					+ peliculas[cima].getGenero());
			cima--;
			mS.pop();
		}
	}

	public boolean pilaLlena() {
		return (cima == tamañoPila - 1) ? true : false;
	}

	public boolean pilaVacia() {

		return (cima == -1) ? true : false;
	}

	public void devolverPelicula() {
		if (pilaLlena()) {
			System.out.println("No hay peliculas para devolver");
		} else {
			mS.push(peliculas[cima]);
			cima++;
			System.out.println("Se a devuelto la pelicula " + peliculas[cima].getTitulo() + " del genero "
					+ peliculas[cima].getGenero());
		}
	}

	public void mostrarDisponibles() {
		System.out.println("Total de peliculas: " + mS.size());
	}

	@Override
	public void cargarBaseDatos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rentar() {
		// TODO Auto-generated method stub
		
	}
}

class ImplementacionPilaEstatica implements RentaPeliculas {

	private int cima = 4;
	private int tamañoPila = 5;
	private String peliculas[][] = new String[2][5];

	public void cargarBaseDatos() {
		
		peliculas[0][3] = "4) terminator";
		peliculas[1][3] = "cienciaficcion";
		peliculas[0][4] = "5) eso";
		peliculas[1][4] = "Terror";
		peliculas[0][0] = "1.- viernes 13";
		peliculas[1][0] = "Terror";
		peliculas[0][1] = "2) vengadores";
		peliculas[1][1] = "Accion";
		peliculas[0][2] = "3) juracic park";
		peliculas[1][2] = "Sobrenatural";

		
		System.out.println("base cargada");
	}

	public void rentar() {
		if (pilaVacia()) {
			System.out.println("no hay mas peliculas . . .");
		} else {
			System.out.println("Has rentado la pelicula " + peliculas[0][cima] + " del genero " + peliculas[1][cima]);
			cima--;
		}
	}

	public boolean pilaLlena() {
		return (cima == tamañoPila - 1) ? true : false;
	}

	public boolean pilaVacia() {

		return (cima == -1) ? true : false;
	}

	public void devolverPelicula() {
		if (pilaLlena()) {
			System.out.println("No hay peliculas para devolver");
		} else {
			cima++;
			System.out.println("Se a devuelto la pelicula " + peliculas[0][cima] + " del genero " + peliculas[1][cima]);
		}
	}

	public void mostrarDisponibles() {
		System.out.println("Peliculas disponibles: ");
		for (int i = 0; i <= cima; i++) {
			System.out.println(peliculas[0][i] + " del genero " + peliculas[1][i]);
		}
		System.out.println("Total de peliculas: " + (cima + 1));
	}
}

class Pelicula {

	private String titulo;
	private String genero;

	public Pelicula(String titulo, String genero) {
		super();
		this.titulo = titulo;
		this.genero = genero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
}

public class pruebaPila {

	public static void main(String[] args) {

		ImplementacionPilaEstatica pe1 = new ImplementacionPilaEstatica();
		ImplementacionPilaDinamica pd1 = new ImplementacionPilaDinamica();
		System.out.println("Ingrese una opcion");
		Scanner e = new Scanner(System.in);
		System.out.println("1.- Pila dinamica");
		System.out.println("2.- Pila Estatica");
		int op = e.nextInt();
		int cont = 0;

		if (op == 1) {
			do {
				System.out.println("Bienvenido a Rec");
				System.out.println("Ingrese una opcion");
				System.out.println("1.-Cargar Base de Datos");
				System.out.println("2.-Rentar peliculas");
				System.out.println("3.-Realizar devolucion");
				System.out.println("4.-Mostrar pelicula");
				System.out.println("5.-Salir");
				op = e.nextInt();
				switch (op) {

				case 1:
					pe1.cargarBaseDatos();
					break;
				case 2:
					pe1.rentar();
					break;
				case 3:
					pe1.devolverPelicula();
					break;
				case 4:
					pe1.mostrarDisponibles();
					break;
				case 5:
					System.out.println("Nos vemos!");
					cont++;
					break;
				}
			} while (cont < 1);
		} else if (op == 2) {
			do {
				System.out.println("Bienvenido a Rec");
				System.out.println("Ingrese una opcion");
				System.out.println("1.-Cargar Base de Datos");
				System.out.println("2.-Rentar peliculas");
				System.out.println("3.-Realizar devolucion");
				System.out.println("4.-Mostrar pelicula");
				System.out.println("5.-Salir");
				op = e.nextInt();
				switch (op) {

				case 1:
					pd1.cargarBD();
					break;
				case 2:
					pd1.rentaPeliculas();
					break;
				case 3:
					pd1.devolverPelicula();
					break;
				case 4:
					pd1.mostrarDisponibles();
					break;
				case 5:
					System.out.println("Nos vemos!");
					cont++;
					break;
				}
			} while (cont < 1);
		} else if (op == 3) {
			System.out.println("Salir");
		}

	}
}
