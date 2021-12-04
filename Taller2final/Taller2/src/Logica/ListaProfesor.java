package Logica;
import Dominio.*;

/**
 * description of class ListaProfesor{ 
 *
 * @author CarvajalAlvarez
 * @version 
 */
public class ListaProfesor{
	private int cant;
	private int max;
	private Profesor[] lista;
	
	public ListaProfesor(int max) {
		this.max=max;
		cant=0;
		lista= new Profesor[max];
	}
	public boolean ingresarProfesor(Profesor profesor) {
		if(cant<max) {
			lista[cant]=profesor;
			cant++;
			return true;
		}
		return false;
	}
	public Profesor buscarProfesor(String rut) {
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
	
	public Profesor buscarCorreo(String correo) {
		for(int i=0; i<cant; i++){			
			Profesor profesor = lista[i];
            String aux = profesor.getCorreo();
            if(aux.equals(correo)){
                return profesor;
            } 
        }
		
        return null;
    }
	
	public Profesor getListaProfesorI(int i) {
		if(i>=0 && i<cant) {
			return lista[i];
		}
		return null;
	}

}