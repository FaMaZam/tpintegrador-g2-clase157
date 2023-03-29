package ArgentinaProgramaV001;

/**
* -- Personas V 0.0.1 --
* Carga los datos de la persona (DNI, nombre,apellido) desde un file. Carga dicho file con 
* pronóstico y lo devuelve en formato LEV junto con el índice LEV e indice de la
* persona(idxPersona, idxPronostico,resultado(LEV)).
* 
*/
public class Personas {
	String nombre, apellido, DNI; // Para la siguiente entrega
	String path;
	String elResultado[][];
	String lev[][];

	public Personas(String path) {
		this.path = path;
	}

	public String[][] evaluaPronostico() {
		int filas = 0;
		int levIdx = 4; // Posicion en matriz de inicio lev (4,5,6)
		String delimOut = " ";
		elResultado = UtilCurso.fileToMatrix(this.path);
//		UtilCurso.displayMatrix2D(elResultado, delimOut);
		String lev[][] = new String[elResultado.length][2];

		while (filas < elResultado.length) {
			if (elResultado[filas][levIdx].toLowerCase().equals("x")) {
				lev[filas][0] = elResultado[filas][1];
				lev[filas][1] = "L";
			} else if (elResultado[filas][levIdx + 1].toLowerCase().equals("x")) {
				lev[filas][0] = elResultado[filas][1];
				lev[filas][1] = "E";
			} else if (elResultado[filas][levIdx + 2].toLowerCase().equals("x")) {
				lev[filas][0] = elResultado[filas][1];
				lev[filas][1] = "V";
			}
			++filas;
		}
		this.lev = lev;
		return lev;
	}
}
