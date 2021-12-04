package Logica;
import Dominio.*;

/**
 * description of class ListaParalelo 
 *
 * @author CarvajalAlvarez
 * @version 
 */
public class ListaParalelo {
	private int cant;
	private int max;
	private Paralelo[] lista;
	
	public ListaParalelo(int max) {
		this.max=max;
		cant=0;
		lista= new Paralelo[max];
	}
	public boolean ingresarParalelo(Paralelo paralelo) {
		if(cant<max) {
			lista[cant]=paralelo;
			cant++;
			return true;
		}
		return false;
	}
		
	public Paralelo buscar(String codigo, String numero) {
		for(int i=0; i<cant; i++){	
			Paralelo paralelo = lista[i];
            String Aux1 = paralelo.getCodigoParalelo();
            String Aux2 = paralelo.getNumeroParalelo();
            if(Aux1.equals(codigo)&&Aux2.equals(numero)){
                return paralelo;
            }
        }
        return null;
    }
	
	public int getCant(){
        return cant;
    }
	
	public Paralelo getParaleloI(int i) {
		if(i>=0 && i<cant) {
			return lista[i];
		}
		return null;
	}
	
	public boolean eliminar(String codigo) {
		int i;
        for(i=0;i<cant; i++){
            if(lista[i].getCodigoParalelo().equals(codigo)){
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


}