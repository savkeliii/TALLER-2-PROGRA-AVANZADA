package Logica;
import Dominio.*;

/**
 * description of class ListaAsignatura 
 *
 * @author CarvajalAlvarez
 * @version 
 */
public class ListaAsignatura {
	private int cant;
	private int max;
	private Asignatura[] lista;
	
	public ListaAsignatura(int max) {
		this.max=max;
		cant=0;
		lista= new Asignatura[max];
	}
	public boolean ingresarAsignatura(Asignatura asignatura) {
		if(cant<max) {
			lista[cant]=asignatura;
			cant++;
			return true;
		}
		return false;
	}
	
	public Asignatura buscarAsignatura(String codigo) {
		for(int i=0;i<cant;i++) {
			if(lista[i].getNombreAsignatura()==codigo) {
				return lista[i];
			}
		}
		return null;
	}
	
	public int getCant(){
        return cant;
    }
	
	public int creditosAsignatura() {
		int salida = 0;
		for (int i = 0; i< cant ; i++) {
			Asignatura a = lista[i];
			salida += a.getCreditos();
		}
		return salida;
	}
	
	public Asignatura getAsignaturaI(int i) {
		if(i>=0 && i<cant) {
			return lista[i];
		}
		return null;
	}
	
	public boolean eliminar(String codigo) {
		int i;
        for(i=0; i<cant; i++){
            if(lista[i].getCodigoAsignatura().equals(codigo)) {
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


    /**
     * @param cant the cant to set
     */
    public void setCant(int cant) {
        this.cant = cant;
    }

    /**
     * @return int return the max
     */
    public int getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * @return Asignatura[] return the lista
     */
    public Asignatura[] getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(Asignatura[] lista) {
        this.lista = lista;
    }

}