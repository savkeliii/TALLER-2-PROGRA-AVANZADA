package Dominio;
import Logica.*;

public class Estudiante {
	private String rut;
	private String correo;
	private int nivel;
	private String contraseña;
	private String asignatura;
	private String codigoAsignaturaCursada;
	private String codigoAsignaturaInscrita;
	private String numeroParalelo;
	private int cantidadAsignaturasCursadas;
	private int cantidadAsignaturasInscritas;
	private int nota;
	private int asignaturasInscritas;
	private int creditos;
	private ListaAsignatura listaAsignatura;
	private ListaParalelo listaParalelo;
	
	public Estudiante(String rut, String correo, int nivel, String contraseña, String asignatura, int nota,int asignaturasInscritas, int creditos,
			int cantidadAsignaturasInscritas,int cantidadAsignaturasCursadas, String codigoAsignaturaCursada,String codigoAsignaturaInscrita,String numeroParalelo) {
		this.rut=rut;
		this.correo=correo;
		this.nivel=nivel;
		this.contraseña=contraseña;
		this.asignatura=asignatura;
		this.codigoAsignaturaCursada=codigoAsignaturaCursada;
		this.codigoAsignaturaInscrita=codigoAsignaturaInscrita;
		this.numeroParalelo=numeroParalelo;
		this.cantidadAsignaturasInscritas=cantidadAsignaturasInscritas;
		this.cantidadAsignaturasCursadas=cantidadAsignaturasCursadas;
		this.nota=nota;
		this.asignaturasInscritas=asignaturasInscritas;
		this.creditos = creditos;
		listaAsignatura = new ListaAsignatura(10);
		listaParalelo = new ListaParalelo(10);
		
	}


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

    /**
     * @return String return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return int return the nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * @return String return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return String return the asignatura
     */
    public String getAsignatura() {
        return asignatura;
    }

    /**
     * @param asignatura the asignatura to set
     */
    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    /**
     * @return String return the codigoAsignaturaCursada
     */
    public String getCodigoAsignaturaCursada() {
        return codigoAsignaturaCursada;
    }

    /**
     * @param codigoAsignaturaCursada the codigoAsignaturaCursada to set
     */
    public void setCodigoAsignaturaCursada(String codigoAsignaturaCursada) {
        this.codigoAsignaturaCursada = codigoAsignaturaCursada;
    }

    /**
     * @return String return the codigoAsignaturaInscrita
     */
    public String getCodigoAsignaturaInscrita() {
        return codigoAsignaturaInscrita;
    }

    /**
     * @param codigoAsignaturaInscrita the codigoAsignaturaInscrita to set
     */
    public void setCodigoAsignaturaInscrita(String codigoAsignaturaInscrita) {
        this.codigoAsignaturaInscrita = codigoAsignaturaInscrita;
    }

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
     * @return int return the cantidadAsignaturasCursadas
     */
    public int getCantidadAsignaturasCursadas() {
        return cantidadAsignaturasCursadas;
    }

    /**
     * @param cantidadAsignaturasCursadas the cantidadAsignaturasCursadas to set
     */
    public void setCantidadAsignaturasCursadas(int cantidadAsignaturasCursadas) {
        this.cantidadAsignaturasCursadas = cantidadAsignaturasCursadas;
    }

    /**
     * @return int return the cantidadAsignaturasInscritas
     */
    public int getCantidadAsignaturasInscritas() {
        return cantidadAsignaturasInscritas;
    }

    /**
     * @param cantidadAsignaturasInscritas the cantidadAsignaturasInscritas to set
     */
    public void setCantidadAsignaturasInscritas(int cantidadAsignaturasInscritas) {
        this.cantidadAsignaturasInscritas = cantidadAsignaturasInscritas;
    }

    /**
     * @return int return the nota
     */
    public int getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(int nota) {
        this.nota = nota;
    }

    /**
     * @return int return the asignaturasInscritas
     */
    public int getAsignaturasInscritas() {
        return asignaturasInscritas;
    }

    /**
     * @param asignaturasInscritas the asignaturasInscritas to set
     */
    public void setAsignaturasInscritas(int asignaturasInscritas) {
        this.asignaturasInscritas = asignaturasInscritas;
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
     * @return ListaAsignatura return the listaAsignatura
     */
    public ListaAsignatura getListaAsignatura() {
        return listaAsignatura;
    }

    /**
     * @param listaAsignatura the listaAsignatura to set
     */
    public void setListaAsignatura(ListaAsignatura listaAsignatura) {
        this.listaAsignatura = listaAsignatura;
    }

    /**
     * @return ListaParalelo return the listaParalelo
     */
    public ListaParalelo getListaParalelo() {
        return listaParalelo;
    }

    /**
     * @param listaParalelo the listaParalelo to set
     */
    public void setListaParalelo(ListaParalelo listaParalelo) {
        this.listaParalelo = listaParalelo;
    }
	public int contadorCreditos() {
		int creditosAprobados = 0;
		if (this.getNota() >= 3.95) {
			creditosAprobados =creditosAprobados + this.getAsignaturas().creditosAsignatura();
		}
		return creditosAprobados;
	}

	
	public String toStringDatosEstudiante() {
		return "Rut : "+rut+"  Correo : "+correo+"  Nivel : "+nivel+"  Cantidad de Asignaturas cursadas: "+cantidadAsignaturasCursadas+
				"\n Codigos de las asignaturas cursadas: "+codigoAsignaturaCursada+" \n Notas de las asignaturas :"
				+ "cursadas : "+nota+" Cantidad de asignaturas inscritas : "+cantidadAsignaturasInscritas+" Codigos asignaturas inscritas : "+codigoAsignaturaInscrita+" \n"
						+ "Numero de paralelo : "+numeroParalelo+", Cantidad de creditos disponibles : "+creditos;
	}
	
	public String Escritura() {
		return rut + "," + correo+ ","+nivel+","+contraseña+"\n"
				+cantidadAsignaturasCursadas+"\n"+codigoAsignaturaCursada+","+nota+"\n"
				+cantidadAsignaturasInscritas+"\n"+codigoAsignaturaCursada+","+numeroParalelo+"\n";
	}
}
