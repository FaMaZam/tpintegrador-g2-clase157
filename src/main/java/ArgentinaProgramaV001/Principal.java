package ArgentinaProgramaV001;

/**
* -- Principal V 0.0.1 --
* Se instancian las clases y se llaman a los métodos.
* Los resultados se presentan en formato lev, local, empate o visitante.
* Como en los torneos del futbol, el local es el que aparece a la izquierda 
* cuando se declara el partido.
*/
public class Principal {
// Solo agrego un comentario para poder agregar un commit de prueba al repositorio github
	public static void main(String[] args) {
		String numArch ="3";
		String ResultadosPartidos = "src\\main\\java\\ArgentinaProgramaV001\\Recursos\\" + "ResultadosPartidos" + numArch + ".csv";
		String PronosticosPersonas = "src\\main\\java\\ArgentinaProgramaV001\\Recursos\\" + "PronosticosPersonas" + numArch + ".csv";
		String Pronostico = "src\\main\\java\\ArgentinaProgramaV001\\Recursos\\" + "PronosticosPersonas" + numArch + ".csv";

//    	Evaluo si hay entrada por args
		if (args.length == 2 ) {
			ResultadosPartidos = args[0];
			PronosticosPersonas = args[1];
		} else if (args.length != 0 || args.length > 2) {
			System.out.println("Cantidad de parametros incorrecto ! ---> " + args.length + "\n");
			System.exit(0);
		}
//		Instanciar
		Personas misPronosticos = new Personas(PronosticosPersonas);
		Partidos misResultados = new Partidos(ResultadosPartidos);
		Persona miPronostico = new Persona();
		Puntuacion score = new Puntuacion();

//		Resultados
		System.out.println("      ** -- Tabla de resultados -- **\n");
		UtilCurso.displayCsv(ResultadosPartidos); // Descomentar para ver tabla resultados
		UtilCurso.displayMatrix2D(misResultados.evaluaResultado()); // Resultados partidos formato lev
		System.out.println("--------------------------------------------");

//		Pronósticos
		System.out.println("       ** -- Tabla de pronósticos -- **\n");	
		UtilCurso.displayCsv(Pronostico); // Descomentar para ver tabla pronósticos
		UtilCurso.displayMatrix2D(miPronostico.mostraResultadoPronostico(UtilCurso.fileToMatrix(Pronostico)));
		System.out.println("--------------------------------------------");
		
//		Puntaje
		System.out.println("       -- Puntaje --");
		System.out.println("Score = " + score.puntaje(misResultados.evaluaResultado(),
				misPronosticos.evaluaPronostico()));		
	}

}