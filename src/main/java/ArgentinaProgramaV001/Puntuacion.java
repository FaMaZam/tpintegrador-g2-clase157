package ArgentinaProgramaV001;
/**
 *  -- Puntuación V 0.0.1 --
 * Recupera resultado de los partidos y el pronóstico de las personas, las
 * compara y genera la tabla de puntajes de los usuarios pronosticadores.
 * @author Ignacio
 *
 */
public class Puntuacion {
	int score = 0;
	public int puntaje (String misResultados[][], String misPronosticos[][]) {
//		Primero comparo el rango de las matrices. Debe ser igual.		
		if  ((misResultados.length != misPronosticos.length) && 
				(misResultados [0].length != misPronosticos[0].length  )) {
			System.out.println("Matrices son distintas");
			System.exit(0);
		} 
		for (int i = 0; i < misResultados.length; ++i) {
			if (misResultados[i][1] == misPronosticos[i][1]) {
			++score;
			}
		}
		return score;	
	}
}
