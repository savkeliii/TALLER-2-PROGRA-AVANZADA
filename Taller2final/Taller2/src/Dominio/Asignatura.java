package Dominio;
import Logica.*;

public class Asignatura {
	private String codigoAsignatura;
	private String nombreAsignatura;
	private int creditos;
	private ListaParalelo listaParalelos;
	private ListaEstudiante listaEstudiantes;
	
	public Asignatura(String codigoAsignatura, String nombreAsignatura, int creditos) {
		this.codigoAsignatura=codigoAsignatura;
		this.nombreAsignatura=nombreAsignatura;
		this.creditos=creditos;
		listaParalelos = new ListaParalelo(1000);
		listaEstudiantes = new ListaEstudiante(100);
				
	
    /**
     * @return String return the codigoAsignatura
     */
    public String getCodigoAsignatura() {
        return codigoAsignatura;
    }

    /**
     * @param codigoAsignatura the codigoAsignatura to set
     */
    public void setCodigoAsignatura(String codigoAsignatura) {
        this.codigoAsignatura = codigoAsignatura;
    }

    /**
     * @return String return the nombreAsignatura
     */
    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    /**
     * @param nombreAsignatura the nombreAsignatura to set
     */
    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    /**
     * @return int return the creditos
     */
    public int getCreditos() {
        return creditos;
    }

    /**
     * @param creditos the creditos to set
     */
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    /**
     * @return ListaParalelo return the listaParalelos
     */
    public ListaParalelo getListaParalelos() {
        return listaParalelos;
    }

    /**
     * @param listaParalelos the listaParalelos to set
     */
    public void setListaParalelos(ListaParalelo listaParalelos) {
        this.listaParalelos = listaParalelos;
    }

    /**
     * @return ListaEstudiante return the listaEstudiantes
     */
    public ListaEstudiante getListaEstudiantes() {
        return listaEstudiantes;
    }

    /**
     * @param listaEstudiantes the listaEstudiantes to set
     */
    public void setListaEstudiantes(ListaEstudiante listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }
	public ListaParalelo getlParalelos() {
		return listaParalelos;
	}

	public ListaEstudiante getlEstudiantes() {
		return listaEstudiantes;
	}
	
	public String toStringAsignatura() {
		return "Codigo: "+codigoAsignatura+", Nombre: "+nombreAsignatura+", Creditos: "+creditos+" \n";
	}
}

		
