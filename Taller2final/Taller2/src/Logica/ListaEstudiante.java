package Logica;
import Dominio.*;

/**
 * description of class ListaEstudiante 
 *
 * @author CarvajalAlvarez
 * @version 
 */
public class ListaEstudiante {
	private int cant;
	private int max;
	private Estudiante[] lista;
	
	public ListaEstudiante(int max) {
		this.max=max;
		cant=0;
		lista= new Estudiante[max];
	}
	public boolean ingresarEstudiante(Estudiante estudiante) {
		if(cant<max) {
			lista[cant]=estudiante;
			cant++;
			return true;
		}
		return false;
	}
	
	public Estudiante buscarEstudiante(String rut) {
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
	
	public Estudiante buscarCorreo(String correo) {
		for(int i=0; i<cant; i++){			
			Estudiante estudiante = lista[i];
            String aux = estudiante.getCorreo();
            if(aux.equals(correo)){
                return estudiante;
            } 
        }
		
        return null;
    }
	
	public Estudiante getListaEstudianteI(int i) {
		if(i>=0 && i<cant) {
			return lista[i];
		}
		return null;
	}
	
	public boolean eliminar(String rut) {
		int i;
        for(i=0; i<cant; i++){
            if(lista[i].getRut().equals(rut)){
                break;
            }
        }        
        if(i==cant){
            return false;
        }      
        else {   	
            for(int j = i;j<cant-1;j++){      	
                lista[j] = lista[j+1];
            }
            cant--;       
            return true;
        }
	}
	
	public String Escritura() {
		String salida = "";
		for (int i = 0; i < cant; i++) {
			Estudiante estudiante = lista[i];
			salida += estudiante.Escritura();
		}
		return salida;
	}
	
	public String toStringEstudiante() {
		String salida = "";
		for (int i = 0; i < cant; i++) {
			Estudiante estudiante = lista[i];
			salida += estudiante.toStringDatosEstudiante();
		}
		return salida;
	}

}
