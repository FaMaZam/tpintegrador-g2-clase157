package ArgentinaProgramaV001;

/**
 * -- Partidos V 0.0.1 --
 * A partir de los resultados en un file, implementa 
 * una tablade L-E-V (local, empate, visitante) para
 * poder compararcon con el pronóstico de las personas.
 * Se referencia mediante los índices de los partidos.
 * Devuelve el resultado en un String.
 * P.D Corre el concepto local - visitante, es decir que si
 * se informa "Ganador" implica que el local fué el ganador.
 */
public class Partidos {
	String path;
	String elResultado[][];
	String lev [][];
	
	public Partidos (){
	}
	public Partidos (String path){
		this.path = path;
	}

/**
 * -- evaluaResultado --
 * A partir del file de resultados genera una matriz. Luego toma la matriz con
 * el resultado con los goles y lo convierte a una matriz estilo Prode donde
 * da el resultado de la siguiente manera:
 * Local-Visitante-(L, E o V). En realidad devuelvo idx de la ronda + resultado
 * (idx,resultado(LEV))
 * @param No hay, El path se le pasa al constructor
 * @dependencias UtilCurso.fileToMatrix, UtilCurso.displayMatrix2D
 * @return lev
 */
	public String [][] evaluaResultado() { //String elResultado[][]
		int filas = 0;
		int golesIdxL = 3; // Posicion Goles Local en la matriz
		int golesIdxV = 4; // Posicion Goles Visitante en la matriz
	
		elResultado = UtilCurso.fileToMatrix(this.path);
//		UtilCurso.displayMatrix2D(elResultado);
		String lev [][] = new String [elResultado.length][2]; // lev ---> local, empate o visitante
		while (filas < elResultado.length) {
			if (Integer.parseInt(elResultado [filas] [golesIdxL]) - Integer.parseInt(elResultado [filas] [golesIdxV]) > 0) {
				lev [filas] [0] = elResultado [filas] [0];
				lev [filas] [1] = "L";			
			} 	else if (Integer.parseInt(elResultado [filas] [golesIdxL]) - Integer.parseInt(elResultado [filas] [golesIdxV]) == 0) {
				lev [filas] [0] = elResultado [filas] [0];
				lev [filas] [1] = "E";
			}	else if (Integer.parseInt(elResultado [filas] [golesIdxL]) - Integer.parseInt(elResultado [filas] [golesIdxV]) < 0) {
				lev [filas] [0] = elResultado [filas] [0];
				lev [filas] [1] = "V";
			}
			++filas;
		}
		return lev;
	}
// --- main() para test ---	
	public static void main(String[] args) {
		
//		String ruta = "C:\\Users\\Ignacio\\eclipse-workspace\\"
//		+ "ArgentinaPrograma\\src\\main\\java\\tpIntegrador\\ArgentinaPrograma\\Recursos\\ResultadosPartidos.csv";
//		Partidos tempo = new Partidos(ruta);
////		UtilCurso.displayMatrix2D(tempo.matrixResultadoPartido(ruta));
//		System.out.println("--------------------------------");
//		UtilCurso.displayMatrix2D(tempo.evaluaResultado(), ",");
//		System.out.println("--------------------------------");
//		UtilCurso.displayMatrix2D(tempo.lev, ",");//No se puede invocar a "lev" sin haber llamado a evaluaResultado() !	}
	}
}