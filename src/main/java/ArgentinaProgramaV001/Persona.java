package ArgentinaProgramaV001;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
 /*
 * @author Fabiana
 */
public class Persona {
    public String ruta;
    public String tempo[][];
    public int columnas;
    
    public int setColumnas() {
    this.ruta= "C:\\Users\\Ignacio\\eclipse-workspace\\ArgentinaPrograma\\src\\main\\java\\ArgentinaProgramaV001\\Recursos\\Pronostico.csv";
   	this.tempo = new String[3][6];
	
   	try {
		BufferedReader reader;
		reader = new BufferedReader(new FileReader(ruta));
		String line = reader.readLine();
		    //int i=0;
		    //this.columnas=0;
		while (line != null) {
		    	line = reader.readLine();
		            this.columnas++;
				}
		reader.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        return this.columnas;
    }
    
    public String [][] leerPronostico() {
    this.ruta= "C:\\Users\\Ignacio\\eclipse-workspace\\ArgentinaPrograma\\src\\main\\java\\ArgentinaProgramaV001\\Recursos\\PronosticosPersonas.csv";
    BufferedReader reader;
	this.tempo = new String[2][6];
	
	try {
		reader = new BufferedReader(new FileReader(ruta));
		String line = reader.readLine();
		    int i=0;
		    this.columnas=0;
		while (line != null) {
		    	tempo[i]= line.split(";");
			//System.out.println(line);
			line = reader.readLine();
		            i++;
		            this.columnas++;
				}
		reader.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
        return tempo;
    }
    
    public String [][] mostraResultadoPronostico (String[][] tempo) {
        String [][] resultadoPronostico = new String[tempo.length-1][2];
        int j=2;
        for (int fila=-0; fila<tempo.length-1;fila++){
            //for ( int j=2; j< (setColumnas()-1);j++){
            if(tempo[fila+1][j].equals("x")){
	            resultadoPronostico[fila][j-2]=tempo[fila+1][j-2];
	            resultadoPronostico[fila][j-1]="L";
        	} else if (tempo[fila+1][j+1].equals("x")){
               resultadoPronostico[fila][j-2]=tempo[fila+1][j-2];
               resultadoPronostico[fila][j-1]="E"; 
            } else if (tempo[fila+1][j+2].equals("x")){
               resultadoPronostico[fila][j-2]=tempo[fila+1][j-2];     
               resultadoPronostico[fila][j-1]="V"; 
            }
        }
        return resultadoPronostico;
    }

}


