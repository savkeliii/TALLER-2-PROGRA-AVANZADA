package Logica;
import java.util.Scanner;

import Dominio.Estudiante;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;


class App {

	public static void main(String[] args) throws IOException, ParseException {
		SistemaUCR sistema= new SistemaUCRImpl();
		LecturaEstudiante(sistema);
		LecturaProfesor(sistema);
		LecturaParalelo(sistema);
		LecturaAsignatura(sistema);
		Menu(sistema);
		MenuUsuarioAlumno(sistema);
		MenuUsuarioProfesor(sistema);
		MenuAdmin(sistema);
		
	}
	public static void LecturaEstudiante(SistemaUCR sistema) {
		try {
			File file = new File("Estudiantes2.txt");
			Scanner scan = new Scanner(file);
			boolean ingreso = true;
			int contador=0;
			while(scan.hasNextLine()) {
				String linea = scan.nextLine();
				String [] partes = linea.split(",");
				if(partes.length>1) {
					String rut = partes[0]; 
					String correo = partes[1]; 
					int nivel = Integer.parseInt(partes[2]);
					String contraseña = partes[3];
					linea = scan.nextLine();
					if(partes.length==1) {
						linea = scan.nextLine();
						String asignatura = partes[4];
						int nota= Integer.parseInt(partes[5]);
						int cantidadAsignaturas= Integer.parseInt(partes[6]);
						int creditos = 0;
						String numeroParalelo = "";
						String codigoAsignaturaCursada ="";
						int cantidadAsignaturasInscritas =+cantidadAsignaturas;
						String codigoAsignaturaInscrita="";
						int cantidadAsignaturasCursadas = cantidadAsignaturas;
						int asignaturasInscritas = 0;
						ingreso = sistema.ingresarEstudiante(rut,correo,nivel,contraseña,asignatura,nota,asignaturasInscritas, creditos,
								cantidadAsignaturasInscritas,cantidadAsignaturasCursadas,codigoAsignaturaCursada,codigoAsignaturaInscrita,numeroParalelo);
					}
				
				}
					if(!ingreso) {
						System.out.println("La lista esta llena");
					}
					try {
						
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
						break;
					}										
			}
			scan.close();
		}catch(FileNotFoundException ex) {
			System.out.println(ex.getMessage());
			
		}
	}
	
	
	public static void LecturaProfesor(SistemaUCR sistema) {
		try {
			File file = new File("Profesores.txt");
			Scanner scan = new Scanner(file);
			boolean ingreso = true;
			while(scan.hasNextLine()) {
				String linea = scan.nextLine();
				String [] partes = linea.split(",");
				String rut = partes[0]; 
				String correo = partes[1];
				String contraseña = partes[2];
				int salario = Integer.parseInt(partes[3]);
					ingreso = sistema.ingresarProfesor(rut,correo,contraseña,salario);
					//System.out.println(rut+","+correo+","+contraseña+","+salario);
					if(!ingreso) {
						System.out.println("La lista esta llena");
					}
					try {
						
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
						break;
					}										
			}
			scan.close();
		}catch(FileNotFoundException ex) {
			System.out.println(ex.getMessage());
			
		}
	}
	public static void LecturaParalelo(SistemaUCR sistema) {
		try {
			File file = new File("Paralelos.txt");
			Scanner scan = new Scanner(file);
			boolean ingreso = true;
			while(scan.hasNextLine()) {
				String linea = scan.nextLine();
				String [] partes = linea.split(",");
				String numero = partes[0];
				String codigoAsignatura= partes[1];
				String rut = partes[2];
					ingreso = sistema.ingresarParalelo(numero, codigoAsignatura, rut);
					if(!ingreso) {
						System.out.println("La lista esta llena");
					}
					try {					
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
						break;
					}										
			}
			scan.close();
		}catch(FileNotFoundException ex) {
			System.out.println(ex.getMessage());
			
		}
	}
	
		public static void LecturaAsignatura(SistemaUCR sistema) throws IOException {
			try {
				File file = new File("Asignaturas.txt");
				Scanner scan = new Scanner(file);
				String linea = scan.nextLine();
				boolean ingreso = true;
				while(scan.hasNextLine()) {
					String[] partes = linea.split(",");
					String codigo = partes[0];
					String nombre = partes[1];
					int creditos = Integer.parseInt(partes[2]);
					if(partes[3].equals("obligatoria")) {
					String cantidad = "";
						int nivel = Integer.parseInt(partes[4]);
						int cant = Integer.parseInt(partes[5]);
						for (int i = 6; i < cant+6; i++) {
							cantidad += (partes[i])+",";
						}
						String codigoAsignaturasPrerequisito = cantidad.replaceFirst(".$","");
						ingreso=sistema.ingresarAsignaturaObligatoria(codigo, nombre, creditos, nivel, cant,codigoAsignaturasPrerequisito);
						if(!ingreso) {
							System.out.println("La lista esta llena");
						}
						try {					
						}
						catch(Exception e) {
							System.out.println(e.getMessage());
							break;
						}	
					}		
					if (partes[3].equals("opcional")){
						int creditosPrerequisitos = Integer.parseInt(partes[4]);
						ingreso=sistema.ingresarAsignaturaOpcional(codigo, nombre, creditos, creditosPrerequisitos);
						if(!ingreso) {
							System.out.println("La lista esta llena");
						}
						try {					
						}
						catch(Exception e) {
							System.out.println(e.getMessage());
							break;
						}	
				}
			}
			scan.close();	
			}catch(FileNotFoundException ex) {
				System.out.println(ex.getMessage());
				
		}
	}
	
	public static void Menu(SistemaUCR sistema) throws ParseException{
		Scanner scan = new Scanner(System.in);
		System.out.println("\n------------------------");
		System.out.println("Bienvenido al sistema de la Universidad.");
		System.out.println("Tiene que ingresar su nombre de correo y contrase�a para ingresar.");
		System.out.println("Si es alumno ingrese la letra 'a'");
		System.out.println("Si es profesor ingrese la letra 'p'");
		String ingreso = scan.nextLine();
		if(ingreso.equals("a")) {
			while(true) {
				System.out.println("Si es admin ingrese nombre cuenta : ADMIN y contrase�a	: GHI_789");
				System.out.println("Ingrese su correo: ");
				String correo = scan.nextLine();
				System.out.println("Ingrese su contrase�a: ");
				String contraseña = scan.nextLine();
				if(correo.equals("ADMIN") && contrasena.equals("GHI_789")) {
					MenuAdmin(sistema);
					break;
				}
				try {
					sistema.validarInicioAlumno(correo, contraseña);
					MenuUsuarioAlumno(sistema);				
					
					break;
				}catch(IOException e) {					
					System.out.println(e.getMessage());
					System.out.println("Si desea intentarlo de nuevo, ingrese (y).");
					System.out.println("Si quiere cerrar el sistema, ingrese cualquier tecla/n�mero.");
					if(!scan.nextLine().equals("y"))
						break;
				}				
			}
	    }
		if(ingreso.equals("p")) {
			while(true) {
				System.out.println("Si es admin ingrese nombre cuenta : ADMIN y contrase�a	: GHI_789");
				System.out.println("Ingrese su correo: ");
				String correo = scan.nextLine();
				System.out.println("Ingrese su contrase�a: ");
				String contraseña = scan.nextLine();
				if(correo.equals("ADMIN") && contraseña.equals("GHI_789")) {
					MenuAdmin(sistema);
					
					break;
				}
				
				try {
					sistema.validarInicioProfesor(correo, contraseña);
					MenuUsuarioProfesor(sistema);					
					
					break;
				}catch(IOException e) {					
					System.out.println(e.getMessage());
					System.out.println("Si desea intentarlo de nuevo, ingrese (y).");
					System.out.println("Si quiere cerrar el sistema, ingrese cualquier tecla/n�mero.");
					if(!scan.nextLine().equals("y"))
						break;
				}
			}
		}
		else {
			System.out.println("Los datos son incorrectos");
		}
	
	}
	
	///////////////////////////////////////////////menu alumno///////////////////
	public static void MenuUsuarioAlumno(SistemaUCR sistema) throws ParseException {
		Scanner scan = new Scanner(System.in);
		System.out.println("----MENU ALUMNO----");
		System.out.println("Bienvenido a su menu, a continuaci�n estan las opciones que puede realizar:");
		System.out.println("Ingrese la fecha para ver la opcion correspondiente al semestre : ");
		while (true) {			
			SimpleDateFormat fecha = new SimpleDateFormat("dd/mm/aaaa");
			System.out.println("Ingrese la fecha de hoy (dd/mm/aaaa)");
			Date fech = fecha.parse(scan.next());			
			Date inicioSemestre = fecha.parse("08/03/2021");
			Date terminoinicioSemestre = fecha.parse("02/05/2021");
			Date mitadSemestre = fecha.parse("03/05/2021");
			Date terminomitadSemestre = fecha.parse("11/07/2021");
			Date finalsemestre = fecha.parse("12/07/2021");
			Date terminofinalsemestre = fecha.parse("25/07/2021");
			Date cierre = fecha.parse("26/07/2021");			
			if (fech.before(inicioSemestre)||fech.after(cierre)) {
				System.out.println("Disfrute sus vacaciones"); 
				break;
			}
				if (fech.after(inicioSemestre)&&fech.before(terminoinicioSemestre)) {
					System.out.println("Bienvenido al inicio de semestre");
						System.out.println("Que desea realizar?");
						System.out.println("1) Inscribir asignaturas");
						System.out.println("2) Eliminar asignaturas");
						String opcion1 = scan.next();
						switch(opcion1) {
						case"1":
							System.out.println("Ingrese su correo :");
							String correo = scan.next();
							sistema.obtenerDatosAsignaturasTotal(correo);
							System.out.println("Ingrese el codigo del ramo a inscribir: ");
							String codigo = scan.next();
							System.out.println(sistema.obtenerParalelosRamo(codigo));
							System.out.println("Ingrese el numero del paralelo que quiere inscribir: ");
							String numero = scan.next();
							try {
								sistema.inscribirRamo(correo, codigo, numero);
							}catch (Exception e) {
								System.out.println(e.getMessage());
							}
							break;
							
						case"2":
							System.out.println("Ingrese su correo :");
							String correo1 = scan.next();
							sistema.obtenerRamosEstudiante(correo1);
							System.out.println("Ingrese el codigo del ramo que quiere eliminar: ");
							String codigo1 = scan.next();
							try {
								sistema.eliminarRamo(correo1, codigo1);
							}catch(Exception e){
								System.out.println(e.getMessage());
							}
							break;
						}
						break;
				}
				if (fech.after(mitadSemestre)&&fech.before(terminomitadSemestre)) {
					System.out.println("Bienvenido estudiante, a la mitad del semestre, en este menu puedes eliminar asignaturas.");
					System.out.println("A continuacion se mostraran todas tus asignaturas inscritas: \n");
					System.out.println("Ingrese su correo :");
					String correo = scan.next();
					sistema.obtenerRamosEstudiante(correo);
					System.out.println("\nIngrese el codigo del ramo que quiere eliminar: ");
					String codigoAsignatura = scan.next();
					try {
						sistema.eliminarRamo(correo, codigoAsignatura);
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
					break;
				}	
		}
		scan.close();
	}

	
	
	/////////////////////////////////////////////////////menu profesor/////////////////////
	public static void MenuUsuarioProfesor(SistemaUCR sistema) throws ParseException {
		Scanner scan = new Scanner(System.in);
		System.out.println("----MENU PROFESOR----");
		System.out.println("Bienvenido a su menu, a continuaci�n estan las opciones que puede realizar:");
		System.out.println("Ingrese la fecha para ver la opcion correspondiente al semestre : ");
		while (true) {			
			SimpleDateFormat fecha = new SimpleDateFormat("dd/mm/aaaa");
			System.out.println("Ingrese la fecha de hoy (dd/mm/aaaa)");
			Date fech = fecha.parse(scan.next());			
			Date inicioSemestre = fecha.parse("08/03/2021");
			Date terminoinicioSemestre = fecha.parse("02/05/2021");
			Date mitadSemestre = fecha.parse("03/05/2021");
			Date terminomitadSemestre = fecha.parse("11/07/2021");
			Date finalsemestre = fecha.parse("12/07/2021");
			Date terminofinalsemestre = fecha.parse("25/07/2021");
			Date cierre = fecha.parse("26/07/2021");
			if (fech.before(inicioSemestre)||fech.after(cierre)) {
				System.out.println("Disfrute sus vacaciones"); 
				break;
			}
				if (fech.after(inicioSemestre)&&fech.before(terminoinicioSemestre)) {
					System.out.println("Inicio de semestre");
					System.out.println("Bienvenido Profesor, en seguida inicia el chequeo de alumnos.");
					System.out.println("A continuacion se mostrar�n todos los paralelos que dicta: \n");
					System.out.println("Ingrese su correo :");
					String correo = scan.next();
					sistema.obtenerParalelosProfesor(correo);
					System.out.println("\nIngrese el codigo del ramo: ");
					String codigo = scan.next();
					System.out.println("\nIngrese el numero del paralelo que quiere visualizar sus alumnos: ");
					String numero = scan.next();
					try {
						System.out.println(sistema.obtenerEstudiantesParalelo(codigo, numero));
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break;
			}
			if (fech.after(mitadSemestre)&&fech.before(terminomitadSemestre)) {
				System.out.println("Final de semestre ingresar su correo para poder ingresar la nota final a los alumnos.");
				String correo = scan.next();
				sistema.obtenerParalelosProfesor(correo);
				System.out.println("\nIngrese el codigo del ramo: ");
				String codigo = scan.next();
				System.out.println("\nIngrese el numero del paralelo que quiere visualizar sus alumnos: ");
				String numero = scan.next();		
				sistema.ingresoNotaFinal(numero, codigo, correo);
			}
		}
		
		scan.close();
	}
		
			

	////////////////////////////menu admin/////////////////
	public static void MenuAdmin(SistemaUCR sistema) {
		Scanner scan = new Scanner(System.in);
		System.out.println("----MENU ADMIN----");
		System.out.println("Se guardaran todos los datos y se generara un nuevo archivo");
		cierreSistema(sistema);		
		scan.close();
		
	}
	
	
	
	public static void cierreSistema(SistemaUCR sistema) {
		try {
			BufferedWriter escritura = new BufferedWriter(new FileWriter("Estudiantes.txt"));
			escritura.write(sistema.obtenerDatosEstudiantes());
			escritura.close();
		} catch (Exception e) {
			System.out.println("No se pudo sobreescribir el archivo Estudiantes.txt");
		}

		try {
			BufferedWriter escritura = new BufferedWriter(new FileWriter("Egresados.txt"));
			escritura.write(sistema.obtenerDatosEgresados());
			escritura.close();
		} catch (Exception e) {
			System.out.println("No se pudo crear el archivo Egresados.txt");
		}
	}
	
}


