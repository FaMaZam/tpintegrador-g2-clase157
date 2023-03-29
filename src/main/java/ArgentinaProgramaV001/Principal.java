package ArgentinaProgramaV001;

/**
* -- Principal V 0.0.1 --
* Se instancian las clases y se llaman a los métodos.
* Los resultados se presentan en formato lev, local, empate o visitante.
* Como en los torneos del futbol, el local es el que aparece a la izquierda 
* cuando se declara el partido.
*/
public class Principal {

	public static void main(String[] args) {
		String ResultadosPartidos = "C:\\Users\\Ignacio\\eclipse-workspace\\tpintegrador-g2-clase157-V1-0\\src\\main\\java\\ArgentinaProgramaV001\\Recursos\\ResultadosPartidos.csv";
		String PronosticosPersonas = "C:\\Users\\Ignacio\\eclipse-workspace\\tpintegrador-g2-clase157-V1-0\\src\\main\\java\\ArgentinaProgramaV001\\Recursos\\PronosticosPersonas.csv";		
		String Pronostico = "C:\\Users\\Ignacio\\eclipse-workspace\\tpintegrador-g2-clase157-V1-0\\src\\main\\java\\ArgentinaProgramaV001\\Recursos\\Pronostico.csv";
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
		System.out.println("       -- Tabla de resultados --\n");
		UtilCurso.displayCsv(ResultadosPartidos); // Descomentar para ver tabla resultados
		UtilCurso.displayMatrix2D(misResultados.evaluaResultado()); // Resultados partidos formato lev
		System.out.println("--------------------------------------------");

//		Pronósticos
		System.out.println("       -- Tabla de pronósticos --\n");	
		UtilCurso.displayCsv(Pronostico); // Descomentar para ver tabla pronósticos
		UtilCurso.displayMatrix2D(miPronostico.mostraResultadoPronostico(UtilCurso.fileToMatrix(Pronostico)));
		System.out.println("--------------------------------------------");
		
//		Puntaje
		System.out.println("       -- Puntaje --");
		System.out.println("Score = " + score.puntaje(misResultados.evaluaResultado(),
				misPronosticos.evaluaPronostico()));		
	}

}