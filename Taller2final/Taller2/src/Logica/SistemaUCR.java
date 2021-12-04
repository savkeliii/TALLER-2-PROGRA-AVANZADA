package Logica;

import java.io.IOException;

public interface SistemaUCR {

	public boolean ingresarProfesor(String rut, String correo, String contraseña, int salario);
	public boolean ingresarAsignaturaOpcional(String CodigoAsignatura, String NombreAsignatura, int Creditos,
			int creditosPrerequisito);
	public boolean ingresarAsignaturaObligatoria(String CodigoAsignatura, String NombreAsignatura, int Creditos, int nivel,
			int cantidadPrerequisito, String codigo);
	public void validarInicioAlumno(String correo, String contraseña) throws IOException;
	public void validarInicioProfesor(String correo, String contraseña) throws IOException;
	public boolean ingresarEstudiante(String rut, String correo, int nivel, String contraseña, String asignatura,
			int nota, int asignaturasInscritas, int creditos, int cantidadAsignaturasInscritas,
			int cantidadAsignaturasCursadas, String codigoAsignaturaCursada, String codigoAsignaturaInscrita,
			String numeroParalelo);
	public String obtenerEstudiantesParalelo(String codigoParalelo, String numeroParalelo);
	public String obtenerParalelosProfesor(String correo);
	boolean ingresarParalelo(String numeroParalelo, String codigoParalelo, String rutProfesor);
	public void asociarEstudianteParaleloAsignatura(String rut, String codigo, String numeroParalelo);
	public void asociarParaleloAsignatura(String codigo, String numeroParalelo);
	public void asociarProfesorParalelo(String rut, String codigo, String numeroParalelo);
	public void inscribirRamo(String correo, String codigo, String numeroParalelo);
	public void ingresoNotaFinal(String rut, String codigoAsignatura, String correo);
	public void eliminarRamo(String correo, String codigo);
	public String obtenerParalelosRamo(String codigo);
	public String obtenerDatosAsignaturasObligatorias();
	public String obtenerDatosAsignaturasOpcionales();
	public String obtenerRamosEstudiante(String correo);
	public boolean agregarEgresado(String rut);
	public String obtenerDatosEstudiantes();
	public String obtenerDatosEgresados();
	public String obtenerDatosAsignaturasTotal(String correo);
	

}
