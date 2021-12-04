package Dominio;
public class AsignaturaOpcional extends Asignatura{
	private int creditosPrerequisito;

	public AsignaturaOpcional(String codigoAsignatura, String nombreAsignatura, int creditos,int creditosPrerequisito) {
		super(codigoAsignatura, nombreAsignatura, creditos);
		this.creditosPrerequisito=creditosPrerequisito;
	
	}

    /**
     * @return int return the creditosPrerequisito
     */
    public int getCreditosPrerequisito() {
        return creditosPrerequisito;
    }

    /**
     * @param creditosPrerequisito the creditosPrerequisito to set
     */
    public void setCreditosPrerequisito(int creditosPrerequisito) {
        this.creditosPrerequisito = creditosPrerequisito;
    }
	public String toStringAsignatura() {
		return "Codigo: "+this.getCodigoAsignatura()+", Nombre: "+this.getNombreAsignatura()+", Creditos: "+this.getCreditos()+", Creditos prerequisito: "+creditosPrerequisito+"\n";
	}
}
