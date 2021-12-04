package Logica;
import Dominio.*;

/**
 * description of class ListaEgresado 
 *
 * @author CarvajalAlvarez
 * @version 
 */
public class ListaEgresado {
	private int cant;
	private int max;
	private Egresado[] lista;
	
	public ListaEgresado(int max) {
		this.max = max;
		cant = 0;
		lista = new Egresado[max];
	}
		
	public boolean ingresarEgresado(Egresado egresado) {
		if(cant < max) {
            lista[cant] = egresado;
            cant++;
            return true;
        }
		
        return false;
    }		
	
	public Egresado buscarEgresado(String rut) {
		for(int i=0;i<cant;i++) {
			if(lista[i].getRut().equals(rut)) {
				return lista[i];
			}
		}
		return null;
	}
	
	public int getCant(){
        return cant;
    }
	
	public Egresado getListaEgreasdoI(int i) {
		if(i >= 0 && i <= cant) {
            return lista[i];
        }
		
        return null;
	}

	public String Escritura() {
		String salida = "";
		for (int i = 0; i < cant; i++) {
			Egresado estudiante = lista[i];
			salida += estudiante.Escritura();
		}
		return salida;
	}	
}