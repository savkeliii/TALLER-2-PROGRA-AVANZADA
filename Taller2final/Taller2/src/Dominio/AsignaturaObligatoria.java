package Dominio;

public class AsignaturaObligatoria extends Asignatura{
	
	private int nivelMalla;
	private int cantidadPrerequisito;
	private String codigo;
	
	public AsignaturaObligatoria(String codigoAsignatura, String nombreAsignatura, int creditos,int nivelMalla, int cantidadPrerequisito, String codigo) {
		super(codigoAsignatura, nombreAsignatura, creditos);
		this.nivelMalla=nivelMalla;
		this.cantidadPrerequisito=cantidadPrerequisito;
		this.codigo=codigo;
		
	}

	


    /**
     * @return int return the nivelMalla
     */
    public int getNivelMalla() {
        return nivelMalla;
    }

    /**
     * @param nivelMalla the nivelMalla to set
     */
    public void setNivelMalla(int nivelMalla) {
        this.nivelMalla = nivelMalla;
    }

    /**
     * @return int return the cantidadPrerequisito
     */
    public int getCantidadPrerequisito() {
        return cantidadPrerequisito;
    }

    /**
     * @param cantidadPrerequisito the cantidadPrerequisito to set
     */
    public void setCantidadPrerequisito(int cantidadPrerequisito) {
        this.cantidadPrerequisito = cantidadPrerequisito;
    }

    /**
     * @return String return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
	public String toStringAsignatura() {
		return "Codigo: "+this.getCodigo()+", Nombre: "+this.getNombreAsignatura()+", Creditos: "+this.getCreditos()+", Nivel: "+this.getNivelMalla()+" Asignaturas Prerequisito: "+cantidadPrerequisito+" Asignaturas Prerequisito: "+codigo+"\n";
	}

}
