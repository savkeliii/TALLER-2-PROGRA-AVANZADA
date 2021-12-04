package Logica;
import java.io.IOException;
import java.util.Scanner;
import Dominio.*;


public class SistemaUCRImpl implements SistemaUCR{
	
	private ListaAsignatura listaAsignatura;
	private ListaParalelo listaParalelo;
	private ListaProfesor listaProfesor;
	private ListaEstudiante listaEstudiante;
	private ListaEgresado listaEgresado;
	
	public SistemaUCRImpl() {
		this.listaAsignatura = new ListaAsignatura(1000);
		this.listaEstudiante = new ListaEstudiante(1000);
		this.listaParalelo = new ListaParalelo(1000);
		this.listaProfesor = new ListaProfesor(1000);
	}
	/**
	 * this method allows students with their characteristics to enter and add it to a list
	 */
	@Override
	public boolean ingresarEstudiante(String rut, String correo, int nivel, String contraseña, String asignatura, int nota,int asignaturasInscritas, int creditos,
			int cantidadAsignaturasInscritas,int cantidadAsignaturasCursadas, String codigoAsignaturaCursada,String codigoAsignaturaInscrita,String numeroParalelo) {
		Estudiante e = new Estudiante(rut, correo, nivel, contrase�a, asignatura, nota, asignaturasInscritas,
				cantidadAsignaturasCursadas, cantidadAsignaturasCursadas, cantidadAsignaturasCursadas, numeroParalelo, numeroParalelo, numeroParalelo);
		if(!listaEstudiante.ingresarEstudiante(e)) {
			throw new NullPointerException("La lista de estudiantes esta llena.");
		}
		boolean ingreso = listaEstudiante.ingresarEstudiante(e);
		return ingreso;
		}
	
	/**
	 * this method allows to enter parallels with their characteristics and add it in a list
	 */

	@Override
	public boolean ingresarParalelo(String numeroParalelo, String codigoParalelo, String rutProfesor) {
		Paralelo p = new Paralelo(numeroParalelo,codigoParalelo,rutProfesor);
		if(!listaParalelo.ingresarParalelo(p)) {
			throw new NullPointerException("La lista de paralelos esta llena.");
		}
		boolean ingreso = listaParalelo.ingresarParalelo(p);
		return ingreso;
		}
	/**
	 * this method allows teachers with their characteristics to enter and add it to a list
	 */

	@Override
	public boolean ingresarProfesor(String rut, String correo, String contraseña, int salario ) {
		Profesor pr= new Profesor(rut, correo, contrase�a, salario);
		if(!listaProfesor.ingresarProfesor(pr)) {
			throw new NullPointerException("La lista de profesores esta llena");
		}
		boolean ingreso = listaProfesor.ingresarProfesor(pr);
		return ingreso;
		}
	/**
	 * this method allows entering compulsory subjects with their characteristics and adding it to a list
	 */

	@Override
	public boolean ingresarAsignaturaObligatoria(String codigoAsignatura, String nombreAsignatura, int creditos,int nivelMalla, int cantidadPrerequisito, String codigo) {
		Asignatura ab = new AsignaturaObligatoria(codigoAsignatura, nombreAsignatura, creditos, nivelMalla,cantidadPrerequisito,codigo);
		if(!listaAsignatura.ingresarAsignatura(ab)) {
			throw new NullPointerException("La lista de asignaturas esta llena");
		}
		boolean ingreso = listaAsignatura.ingresarAsignatura(ab);
		return ingreso;
		}
	/**
	 * this method allows to enter optional subjects with their characteristics and add it to a list
	 */

	@Override
	public boolean ingresarAsignaturaOpcional(String codigoAsignatura, String nombreAsignatura, int creditos,int creditosPrerequisito) {
		Asignatura ap = new AsignaturaOpcional(codigoAsignatura, nombreAsignatura, creditos, creditosPrerequisito);
		if(!listaAsignatura.ingresarAsignatura(ap)) {
			throw new NullPointerException("La lista de asignaturas esta llena");
		}
		boolean ingreso = listaAsignatura.ingresarAsignatura(ap);
		return ingreso;
	}
	/**
	 * this method allows to associate parallel subject and student
	 */

	@Override
	public void asociarEstudianteParaleloAsignatura(String rut, String codigo, String numeroParalelo) {
		Paralelo p = listaParalelo.buscar(codigo,numeroParalelo);
		Estudiante e = listaEstudiante.buscarEstudiante(rut);
		Asignatura a = listaAsignatura.buscarAsignatura(codigo);
		
		if(p != null && e != null && a != null) {
			p.getlEstudiantes().ingresarEstudiante(e);
			e.getParalelos().ingresarParalelo(p);
			a.getlEstudiantes().ingresarEstudiante(e);
		}else {
			if (e == null) {
				throw new NullPointerException("El estudiante, la asignatura o el paralelo no existe");
			}
		}
		
	}
	/**
	 * this method allows to associate subject and parallel
	 */

	@Override
	public void asociarParaleloAsignatura(String codigo, String numeroParalelo) {
		Paralelo p = listaParalelo.buscar(codigo,numeroParalelo);
		Asignatura a = listaAsignatura.buscarAsignatura(codigo);
		if(p != null && a != null) {
			p.setAsignatura(a);
			a.getlParalelos().ingresarParalelo(p);
		}else {
			if (a == null) {
				throw new NullPointerException("La asignatura o el paralelo no existe");
			}
		}
	}
	/**
	 * this method allows to associate teacher and parallel
	 */
	@Override
	public void asociarProfesorParalelo(String rut, String codigo, String numeroParalelo) {
		Paralelo p = listaParalelo.buscar(codigo,numeroParalelo);
		Profesor r = listaProfesor.buscarProfesor(rut);
		
		if(p != null && r != null) {
			p.setRutProfesor(rut);
			r.getParalelos().ingresarParalelo(p);
		}else {
			if (r == null) {
				throw new NullPointerException("El profesor o el paralelo no existe");
			}
		}
		
	}
	/**
	 * this method allows validating the start of the student’s session
	 */
	@Override
	public void validarInicioAlumno(String correo, String contraseña)throws IOException { 					
	int i = 0;
		while(i<listaEstudiante.getCant() && !listaEstudiante.getListaEstudianteI(i).equals(correo)) {
		i++;
		}if(i == listaEstudiante.getCant()) 
			throw new IOException("El rut no se encuentra en el sistema.");
		if(!listaEstudiante.getListaEstudianteI(i).getContraseña().equals(contraseña)) 
			throw new IOException("La contrase�a es incorrecta.");
	}
	/**
	 * this method allows to validate the beginning of the teacher’s session
	 */

	@Override
	public void validarInicioProfesor(String correo, String contraseña)throws IOException { 					
	int i = 0;
		while(i<listaProfesor.getCant() && !listaProfesor.getListaProfesorI(i).equals(correo)) {
		i++;
		}if(i == listaProfesor.getCant()) 
			throw new IOException("El rut no se encuentra en el sistema.");
		if(!listaProfesor.getListaProfesorI(i).getContraseña().equals(contraseña)) 
			throw new IOException("La contraseña es incorrecta.");
		}
	/** 
	 *this method allows the student to register in the branches
	 * */	

	@Override
	public void inscribirRamo(String correo, String codigo, String numeroParalelo) {
		Estudiante e = listaEstudiante.buscarCorreo(correo);
		Paralelo p = listaParalelo.buscar(codigo, numeroParalelo);
		Asignatura a = listaAsignatura.buscarAsignatura(codigo);
		if (e != null && p != null && a != null) {
			if (a instanceof AsignaturaObligatoria) {
				AsignaturaObligatoria ab = (AsignaturaObligatoria) a;
				if ((e.getCreditos() > ab.getCreditos()) || (p.getlEstudiantes().getCant() > 0 && p.getlEstudiantes().getCant() <= 100) || (e.getNivel() >= ab.getNivelMalla())) { 
					e.restarCreditos(ab.getCreditos());
					e.getParalelos().ingresarParalelo(p);
					p.getlEstudiantes().ingresarEstudiante(e);
					ab.getlEstudiantes().ingresarEstudiante(e);
				}
				else {
					throw new NullPointerException("Erro en incribir el ramo.");
				}
			}else {
				AsignaturaOpcional ap = (AsignaturaOpcional) a; 
				if (e.contadorCreditos() >= ap.getCreditosPrerequisito() || e.contadorCreditos() >= ap.getCreditosPrerequisito()) {
					e.restarCreditos(ap.getCreditos());
					e.getParalelos().ingresarParalelo(p);
					p.getlEstudiantes().ingresarEstudiante(e);
					ap.getlEstudiantes().ingresarEstudiante(e);
				}else {
					throw new NullPointerException("No cuentas con creditos.");
				}
			}
		}else {
			throw new NullPointerException("El ramo ingresado no existe.");
		}
	}
	/**
	 * this method allows to obtain the data of all the subjects
	 */
	@Override
	public String obtenerDatosAsignaturasTotal(String correo) {
		String salida = "";
		for (int i = 0; i< listaAsignatura.getCant();i++) {
			Paralelo p = listaParalelo.getParaleloI(i);
			Estudiante e = listaEstudiante.buscarCorreo(correo);
			Asignatura a = p.getAsignatura();
			if (a instanceof AsignaturaObligatoria) {
				AsignaturaObligatoria ab = (AsignaturaObligatoria) a;
				if ((e.getCreditos() > ab.getCreditos()) && (p.getlEstudiantes().getCant() > 0 && p.getlEstudiantes().getCant() <= 100) && (e.getNivel() >= ab.getNivelMalla())) {
					salida += listaAsignatura.toString();
				}
				else {
					throw new NullPointerException("Error en obtener los datos de la asignatura");
				}
			}if (a instanceof AsignaturaOpcional) {
				AsignaturaOpcional ap = (AsignaturaOpcional) a; 
				if (e.getCreditos() >= ap.getCreditos() && e.contadorCreditos() >= ap.getCreditosPrerequisito()) {
					salida += listaAsignatura.toString();
				}else {
					throw new NullPointerException("Creditos insufucientes.");
				}
			}
		}
		return salida;
	}
	/**
	 * this method allows to put the final note
	 */
	public void ingresoNotaFinal(String rut, String codigoAsignatura, String correo) {
		Estudiante e = listaEstudiante.buscarEstudiante(rut);
		Profesor p = listaProfesor.buscarCorreo(correo);
		if (e != null && p != null) {
			e.getAsignaturas().buscarAsignatura(codigoAsignatura);
		}	
	}
	/**
	 * this method allows to remove or throw the bouquet
	 */
	@Override
	public void eliminarRamo(String correo, String codigo) {
		Estudiante e = listaEstudiante.buscarCorreo(correo);
		Asignatura a = listaAsignatura.buscarAsignatura(codigo);
		if (e != null && a != null) {
			if(e.getAsignaturas().getCant() > 0) {
				e.getParalelos().eliminar(codigo);
				e.getAsignaturas().eliminar(codigo);
				a.getlEstudiantes().eliminar(e.getRut());
			}
			else {
				throw new NullPointerException("No tienes asignaturas inscritas.");
			}
		}
	}
	/**
	 * this method allows to add the graduate student to the graduated list
	 */
	@Override
	public boolean agregarEgresado(String rut) {
		Egresado e = listaEgresado.buscarEgresado(rut);
		Estudiante l = listaEstudiante.buscarEstudiante(rut);
		if (e != null) {
			throw new NullPointerException("El estudiante, la asignatura o el paralelo no existe");
		}else {
			if (l.getNivel() == 10) {
				Egresado nuevo = new Egresado(rut);
				return listaEgresado.ingresarEgresado(nuevo);
			}
		}
		return true;
	}
	/**
	 * this method allows students to obtain by parallel
	 */

	@Override
	public String obtenerEstudiantesParalelo(String codigoParalelo, String numeroParalelo) {
		Paralelo p = listaParalelo.buscar(codigoParalelo, numeroParalelo);
		if (p != null) {
			return p .getlEstudiantes().toStringEstudiante();
		}
		throw new NullPointerException("No existe el paralelo ");
	}
	/**
	 * this method allows to obtain the parallels that a teacher has
	 */

	@Override
	public String obtenerParalelosProfesor(String correo) {
		Profesor p = listaProfesor.buscarCorreo(correo);
		if (p != null) {
			return p.getParalelos().toString();
		}
		throw new NullPointerException("No existe el profesor ");
	}
	/**
	 * this method allows to obtain the parallels that a branch has
	 */

	@Override
	public String obtenerParalelosRamo(String codigo) {
		Asignatura a = listaAsignatura.buscarAsignatura(codigo);
		if (a != null) {
			return a.getlParalelos().toString();
		}
		throw new NullPointerException("No existe la asignatura ingresada");
	}
	/**
	 * this method allows to obtain the data of the compulsory subject
	 */


	@Override
	public String obtenerDatosAsignaturasObligatorias() {
		return listaAsignatura.toString();
	}
	/**
	 * this method allows to obtain the data of the optional subject
	 */
	@Override
	public String obtenerDatosAsignaturasOpcionales() {
		return listaAsignatura.toString();
	}
	/**
	 * this method allows to obtain the branches of the student
	 */


	@Override
	public String obtenerRamosEstudiante(String correo) {
		Estudiante e = listaEstudiante.buscarCorreo(correo);
		if (e != null) {
			return e.getAsignaturas().toString();
		}
		throw new NullPointerException("No existe el estudiante ");
	}
	/**
	 * this method allows to obtain the data of a student
	 */

	@Override
	public String obtenerDatosEstudiantes() {
		return listaEstudiante.Escritura();
	}
	/**
	 * this method allows to obtain the data of a graduate student
	 */

	@Override
	public String obtenerDatosEgresados() {
		return listaEgresado.Escritura();
	}
	


	
}
