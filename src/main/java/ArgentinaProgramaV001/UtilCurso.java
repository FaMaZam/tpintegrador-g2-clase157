package ArgentinaProgramaV001;

import java.util.Scanner;
import java.util.Random;
import java.io.*;

/**
 * -- UtilCurso V 0.0.1 --
 *
 */
public class UtilCurso {
	public String path;
	int filasColumnas[];

	UtilCurso() {
	}

	UtilCurso(String path) {
		this.path = path;
		System.out.println("El path empleado es : \n" + path + "\n");
	}

	void setPath(String path) {
		this.path = path;
	}

	String getPath() {
		return this.path;
	}

	/**
	 * -- fixture -- 
	 * Este método devuelve una tabla fixture generada aleatoriamente
	 * a partir de AfaEquiposprimera.csv (u otro grupo de equipos, categoría o
	 * torneo).
	 * ********** Sin terminar. Solo se generó fecha 1 **********
	 * 
	 * @dependencias:
	 * @param: path
	 * @return:
	 */
	static String[][] fixture(String path) {
		Random numAleatorio = new Random();
		String tabla[][] = fileToMatrix(path);
		String delimOut = ",";
		int numCampos = 4;
		String elFixture[][] = new String[(tabla.length)/2][numCampos];	
		int randomVisitante;
		int noRepetidos[] = new int[tabla.length];
		
		int x = 0; // indice para poblar por registros a el "elFixture"
		while (x < tabla.length/2) {
			elFixture[x][0] = Integer.toString(x); // índice de la tabla
			elFixture[x][1] = tabla[x][1]; // nombre del local
			randomVisitante = numAleatorio.nextInt(tabla.length);// +1 por definicion del método
			for (int z = 0; z < tabla.length; ++z) {
				if (randomVisitante == noRepetidos[z] || randomVisitante == 0 || randomVisitante < 14) {
					randomVisitante = numAleatorio.nextInt(tabla.length);
				}
			}
			elFixture[x][2] = Integer.toString(randomVisitante + 1);// índice del visitante
			elFixture[x][3] = tabla[randomVisitante][1]; // nombre del visitante
			++x;
		}
		displayMatrix2D(elFixture,delimOut);
		return elFixture;
	}

	/**
	 * --ronda-- Este método devuelve un fixture con rondas, estilo mundial con zona
	 * de grupos y luego octavos, cuartos, semis y final. Obtiene zona de grupos en
	 * forma aleatoria también a partir de AfaEquiposprimera.csv (u otro como
	 * equipos clasificados al mundial).
	 * 
	 * @dependencias:
	 * @param:
	 * @return:
	 */
	static String ronda() {
		return null;

	}

	/**
	 * -- fileToMatrix -- Toma un file (path) tipo csv de x filas e y columnas y
	 * obtiene una matriz matrizTmp[][] que contiene las filas y columnas de la
	 * lista de equipos. En nuestro caso la lista tiene 28 equipos y tres columnas
	 * con "índice", "equipo" y "descripción". El delimitador es "," pero se puede
	 * modificar modificando "delimIn".
	 * 
	 * @param path
	 * @return matrizTmp
	 */
	static String[][] fileToMatrix(String path) {
		Scanner s = null;
		int filasColumnas[] = filasColumnasDelArchivo(path);
		String matrizTmp[][] = new String[filasColumnas[0]][filasColumnas[1]];
		String unaFila = "";
		String delimIn = ",";
		int i = 0;
		int j = 0;

		try {

			s = new Scanner(new BufferedReader(new FileReader(path))).useDelimiter("\n");
			while (s.hasNext()) {
				unaFila = s.next().toString();
//	            	System.out.println(unaFila);
				String tmp[] = unaFila.split(delimIn);
//	            	System.out.println(arr1[0] +  " - " + arr1[1] + " - " + arr1[2]);
				for (String recorro : tmp) {
//	            		System.out.println(uniqVal1);
					matrizTmp[i][j] = recorro.trim(); // Remuevo LF
//	            		System.out.println("matrizTmp[" + i + "][" + j + "] = " + matrizTmp [i][j] + " ");
					++j;
				}
//	            	System.out.print("\n");
				++i;
				j = 0;
//	            	System.out.println("\n" + "-----------------------------");	            	
			}
		} catch (IOException ex) {
			System.out.println("Shit" + ex);
		}

		finally {
			if (s != null) {
				s.close();
			}
		}
//		for (int p = 0; p< filasColumnas[0]; ++p) {
//			for (int q = 0; q < filasColumnas[1]; ++q) {
//    		System.out.print(matrizTmp [p][q] + " ");
//    		}
//			System.out.print("\n");
//    	}
		return matrizTmp;
	}

	/**
	 * -- filasColumnasDelArchivo -- Devuelve la cantidad de filas/registros y
	 * columnas del file. El separador es "delimSpace".
	 * 
	 * @param path
	 * @return filas
	 */
	static int[] filasColumnasDelArchivo(String path) {
		Scanner s = null;
		int filas = 0;
		int columnas = 0;
		String delimSpace = ",";
		String unaFila = "";
		try {
			s = new Scanner(new BufferedReader(new FileReader(path))).useDelimiter("\n");

			while (s.hasNext()) {
				unaFila = s.next();
				++filas;
			}
			columnas = unaFila.split(delimSpace).length;

		} catch (IOException ex) {
			System.out.println("Excepción !" + ex);
		} finally {
			if (s != null) {
				s.close();
			}
		}
		int returnFilasColumnas[] = { filas, columnas };
//        System.out.println(filas + " " + columnas);
		return returnFilasColumnas;
	}

	/**
	 * -- displayMatrix -- Displaya por consola la matriz tabla [][] del file csv
	 * incluido en path. Sin delimitador (al imprimir pongo un espacio " ").
	 * @param path, tabla
	 * @param tabla
	 */
	public static void displayMatrix2D(String tabla[][]) {
		int filas = tabla.length;
		int columnas = tabla[0].length;
		for (int p = 0; p < filas; ++p) {
			for (int q = 0; q < columnas; ++q) {
				System.out.print(tabla[p][q] + " ");			
			}
			System.out.print("\n");
		}
	}	
	
	/**
	 * -- displayMatrix -- Displaya por consola la matriz tabla [][] del file csv
	 * incluido en path. Con delimitador.
	 * @param path, tabla
	 * @param tabla
	 */
	static void displayMatrix2D(String tabla[][], String delimOut) {
		int filas = tabla.length;
		int columnas = tabla[0].length;
		for (int p = 0; p < filas; ++p) {
			for (int q = 0; q < columnas; ++q) {
				if (q ==columnas-1) { // Ultima columna. No imprimo la coma.
				System.out.print(tabla[p][q]);
				} 	else {
					System.out.print(tabla[p][q] + delimOut);
					}				
			}
			System.out.print("\n");
//			int l = tabla[0][0].length();
////		int l = tabla[0][2].length();
////		int indice = tabla.checkIndex(1,3);
//		int ñ = tabla.length;
//		System.out.println(ñ + " ñ Coño!!!");
//		System.out.println(l + " l Coño!!!");
		}
	}
/**
 * -- displayCsv --
 * Displaya por consola un csv.	
 * @param path
 * @dependencias fileToMatrix, displayMatrix2D
 */
	public static void displayCsv (String path) {
		displayMatrix2D(fileToMatrix(path), ",");		
	}


}