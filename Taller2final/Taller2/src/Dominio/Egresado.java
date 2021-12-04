package Dominio;
import Logica.*;

public class Egresado {
	
	private String rut;
	ListaEstudiante listaEstudiante;
	

    /**
     * @return String return the rut
     */
    public String getRut() {
        return rut;
    }

    /**
     * @param rut the rut to set
     */
    public void setRut(String rut) {
        this.rut = rut;
    }
	public ListaEstudiante getlEstudiante() {
		return listaEstudiante;
	}
	
	public String toStringEgresado() {
		return "Rut: "+rut+"\n";
	}
	
	public String Escritura() {
		return rut + "\n\n ";
	}

}