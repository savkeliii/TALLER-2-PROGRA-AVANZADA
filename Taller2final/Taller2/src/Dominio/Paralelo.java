package Dominio;
import Logica.*;

public class Paralelo {
	private String numeroParalelo;
	private String codigoParalelo;
	private String rutProfesor;
	private ListaEstudiante listaEstudiante;
	private Asignatura asignatura;
	
	public Paralelo(String numeroParalelo, String codigoParalelo, String rutProfesor) {
		this.numeroParalelo=numeroParalelo;
		this.codigoParalelo=codigoParalelo;
		this.rutProfesor=rutProfesor;
		listaEstudiante = new ListaEstudiante(100);
		asignatura = null;
		
	
    /**
     * @return String return the numeroParalelo
     */
    public String getNumeroParalelo() {
        return numeroParalelo;
    }

    /**
     * @param numeroParalelo the numeroParalelo to set
     */
    public void setNumeroParalelo(String numeroParalelo) {
        this.numeroParalelo = numeroParalelo;
    }

    /**
     * @return String return the codigoParalelo
     */
    public String getCodigoParalelo() {
        return codigoParalelo;
    }

    /**
     * @param codigoParalelo the codigoParalelo to set
     */
    public void setCodigoParalelo(String codigoParalelo) {
        this.codigoParalelo = codigoParalelo;
    }

    /**
     * @return String return the rutProfesor
     */
    public String getRutProfesor() {
        return rutProfesor;
    }

    /**
     * @param rutProfesor the rutProfesor to set
     */
    public void setRutProfesor(String rutProfesor) {
        this.rutProfesor = rutProfesor;
    }

    /**
     * @return ListaEstudiante return the listaEstudiante
     */
    public ListaEstudiante getListaEstudiante() {
        return listaEstudiante;
    }

    /**
     * @param listaEstudiante the listaEstudiante to set
     */
    public void setListaEstudiante(ListaEstudiante listaEstudiante) {
        this.listaEstudiante = listaEstudiante;
    }

    /**
     * @return Asignatura return the asignatura
     */
    public Asignatura getAsignatura() {
        return asignatura;
    }

    /**
     * @param asignatura the asignatura to set
     */
    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;

	
	public String toStringParalelo() {
		int cupos = (100 - this.getlEstudiantes().getCant());
		return "Numero del paralelo: "+numeroParalelo+" Codigo de la asignatura: "+codigoParalelo+" Rut del profesor : "+rutProfesor+" Cupos disponibles: "+cupos+"\n";
		
	} 

}

	